package com.epam.task.third.logic;

import com.epam.task.third.entity.Point;

public class PointLogic {

    public int calculateDistance(Point a, Point b) {
        if (a.getX() != b.getX()) {
            int distance = a.getX() - b.getX();
            int distanceAbs = Math.abs(distance);
            return distanceAbs;
        } else if (a.getY() != b.getY()) {
            int distance = a.getY() - b.getY();
            int distanceAbs = Math.abs(distance);
            return distanceAbs;
        } else if (a.getZ() != b.getZ()) {
            int distance = a.getZ() - b.getZ();
            int distanceAbs = Math.abs(distance);
            return distanceAbs;
        } else {
            return 0;
        }
    }

    public boolean isTwoCoordinatesOfPointEquals(Point a, Point b) {
        if (a.getX() == b.getX()) {
            if (a.getY() == b.getY()) {
                return true;
            } else if (a.getZ() == b.getZ()) {
                return true;
            } else {
                return false;
            }
        } else if (a.getY() == b.getY()) {
            if (a.getZ() == b.getZ()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
