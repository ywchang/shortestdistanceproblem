package com.thoughtworks.shortestdistanceproblem;

public class Route {
    private final int distance;
    private final String start;
    private final String end;

    public Route(int distance, String start, String end) {
        this.distance = distance;
        this.start = start;
        this.end = end;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
