package com.thoughtworks.shortestdistanceproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<Route> routesAvailable = lookForRoute(start, end);
        return routesAvailable.stream().mapToInt(Route::getDistance).min().orElse(0);
    }

    private List<Route> lookForRoute(String start, String end) {
        List<Route> routesAvailable = new ArrayList<>();
        List<Route> routesMatchingStart = this.routes.stream()
                .filter(r -> r.getStart().equals(start)).collect(Collectors.toList());
        for (Route route : routesMatchingStart) {
            if (route.getEnd().equals(end)) {
                routesAvailable.add(route);
            }
            List<Route> downstreamRoutes = lookForRoute(route.getEnd(), end);
            downstreamRoutes.forEach(dr -> routesAvailable.add(new Route(start, end, route.getDistance() + dr.getDistance())));
        }
        return routesAvailable;
    }

}

