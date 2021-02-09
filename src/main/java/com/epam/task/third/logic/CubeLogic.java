package com.epam.task.third.logic;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Point;

import java.util.List;

public class CubeLogic {

    public static final int NUMBER_OF_CUBE_SIDES = 8;
    private PointLogic pointLogic;

    public CubeLogic() {
        pointLogic = new PointLogic();
    }

    public int calculateSquareOfSide(Cube cube) {
        List<Point> points = cube.getPoints();
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        int edgeLength = pointLogic.calculateDistance(pointA, pointB);
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
        int edgeLength = pointLogic.calculateDistance(pointA, pointB);
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




}
