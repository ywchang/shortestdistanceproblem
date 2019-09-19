package com.thoughtworks.shortestdistanceproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Graph {
    private List<Route> routes = new ArrayList<>();

    public Graph(String graphStr) {
        String[] routeStrList = graphStr.split(",");
        Arrays.stream(routeStrList).forEach(routeStr -> this.routes.add(new Route(
                routeStr.substring(0, 1),
                routeStr.substring(1, 2),
                Integer.parseInt(routeStr.substring(2))
        )));
    }

    public int getShortestDistance(String start, String end) {
        Optional<Route> routeFound = lookForRoute(start, end);
        return routeFound.map(Route::getDistance).orElse(0);
    }

    private Optional<Route> lookForRoute(String start, String end) {
        List<Route> routesMatchingStart = this.routes.stream()
                .filter(r -> r.getStart().equals(start)).collect(Collectors.toList());
        for (Route route : routesMatchingStart) {
            if (route.getEnd().equals(end)) {
                return Optional.of(route);
            }
            Optional<Route> downStreamRoute = lookForRoute(route.getEnd(), end);
            if (downStreamRoute.isPresent()) {
                return Optional.of(new Route(start, end, route.getDistance() + downStreamRoute.get().getDistance()));
            }
        }
        return Optional.empty();
    }

}

