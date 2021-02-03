package com.epam.task.third.logic;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Figure;
import com.epam.task.third.entity.Point;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class CubeLogic {

    public static final int NUMBER_OF_CUBE_SIDES = 8;

    public boolean isCube(Figure figure) {

        throw new NotImplementedException();
    }

    public int calculateSquareOfSide(Cube cube) {
        List<Point> points = cube.getPoints();
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        int edgeLength = calculateDistance(pointA, pointB);
        int squareOfSide = edgeLength * edgeLength;
        return squareOfSide;
    }

    public int calculateSquareOfCubeSurface(Cube cube) {
        int squareOfSide = calculateSquareOfSide(cube);
        int squareOfCubeSurface = squareOfSide * NUMBER_OF_CUBE_SIDES;
        return squareOfCubeSurface;
    }

    public int calculateVolume(Cube cube) {
        List<Point> points = cube.getPoints();
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        int edgeLength = calculateDistance(pointA, pointB);
        int cubeVolume = edgeLength * edgeLength * edgeLength;
        return cubeVolume;
    }

    public boolean isBaseOfCubeOnPlaneX(Cube cube) {
        int countPointsOnPlaneX = 0;
        List<Point> pointList = cube.getPoints();
        for (Point point : pointList) {
            if (point.getX() == 0) {
                countPointsOnPlaneX++;
            }
        }
        if (countPointsOnPlaneX == 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBaseOfCubeOnPlaneY(Cube cube) {
        int countPointsOnPlaneY = 0;
        List<Point> pointList = cube.getPoints();
        for (Point point : pointList) {
            if (point.getY() == 0) {
                countPointsOnPlaneY++;
            }
        }
        if (countPointsOnPlaneY == 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBaseOfCubeOnPlaneZ(Cube cube) {
        int countPointsOnPlaneZ = 0;
        List<Point> pointList = cube.getPoints();
        for (Point point : pointList) {
            if (point.getZ() == 0) {
                countPointsOnPlaneZ++;
            }
        }
        if (countPointsOnPlaneZ == 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBaseOfCubeOnAnyCoordinatePlane(Cube cube) {
        if (isBaseOfCubeOnPlaneX(cube)) {
            return true;
        }
        if (isBaseOfCubeOnPlaneY(cube)) {
            return true;
        }
        if (isBaseOfCubeOnPlaneZ(cube)) {
            return true;
        }
        return false;
    }

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

    public boolean isPointsAtLine(Point a, Point b) {
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
