package com.epam.task.third.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Figure {

    private final List<Point> points;

    public Figure(Point... points) {
        this.points = Arrays.asList(points);
    }

    public Figure(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figure)) return false;
        Figure figure = (Figure) o;
        return points.equals(figure.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + points +
                '}';
    }
}
