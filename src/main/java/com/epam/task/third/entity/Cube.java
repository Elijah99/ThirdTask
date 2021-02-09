package com.epam.task.third.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cube {
    private final List<Point> points;

    public Cube(List<Point> points) {
        this.points = points;
    }

    public Cube(Point... points){
        this.points = Arrays.asList(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cube)) {
            return false;
        }
        Cube cube = (Cube) o;
        return points.equals(cube.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Cube{" +
                "points=" + points +
                '}';
    }
}
