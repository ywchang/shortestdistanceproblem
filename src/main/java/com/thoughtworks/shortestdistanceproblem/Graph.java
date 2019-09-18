package com.thoughtworks.shortestdistanceproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Graph {
    private List<Route> routes = new ArrayList<>();

    public Graph(String graphStr) {
        String[] routeStrList = graphStr.split(",");
        Arrays.stream(routeStrList).forEach(routeStr -> this.routes.add(new Route(
                Integer.parseInt(routeStr.substring(2)),
                routeStr.substring(0,1),
                routeStr.substring(1,2)
        )));
    }

    public int getShortestDistance(String start, String end) {
        Optional<Route> routeFound = this.routes.stream().filter(r -> r.getStart().equals(start) && r.getEnd().equals(end)).findAny();
        return routeFound.isPresent() ? routeFound.get().getDistance() : 0;
    }
}

