package com.epam.task.third.creator;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Point;
import com.epam.task.third.logic.PointLogic;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubeValidator {

    private static final String CUBE_STRING_PATTERN = "(\\d+\\s\\d+\\s\\d+,){7}(\\d+\\s\\d+\\s\\d+\\n?)";
    private final int countConnectedPointExpected = 3;
    private PointLogic pointLogic;

    public CubeValidator() {
        pointLogic = new PointLogic();
    }

    public boolean validateString(String string) {
        Pattern linePattern = Pattern.compile(CUBE_STRING_PATTERN);
        Matcher matcher = linePattern.matcher(string);
        return matcher.matches();
    }

    public boolean isCube(Cube cube) {
        List<Point> points = cube.getPoints();
        if (points.size() != 8) {
            return false;
        }
        if (!isCountConnectedPointsValid(points)) {
            return false;
        }
        int edgeLength = calculateCubeEdgeLength(points);
        if (!isDistanceBetweenConnectedPointsEquals(points, edgeLength)) {
            return false;
        }

        return true;
    }

    private int calculateCubeEdgeLength(List<Point> points) {
        int edgeLength = 0;
        for (int i = 0; i < points.size(); i++) {
            Point pointA = points.get(0);
            Point pointB = points.get(i);
            if (pointLogic.isTwoCoordinatesOfPointEquals(pointA, pointB) && edgeLength == 0) {
                edgeLength = pointLogic.calculateDistance(pointA, pointB);
            }
        }
        return edgeLength;
    }

    private int countPointsConnectedByEdge(List<Point> points, Point currentPoint) {
        int countPoints = 0;
        for (int i = 0; i < points.size(); i++) {
            Point pointToCheck = points.get(i);
            boolean isTwoCoordinatesOfPointEquals = pointLogic.isTwoCoordinatesOfPointEquals(currentPoint, pointToCheck);
            if (!currentPoint.equals(pointToCheck) && isTwoCoordinatesOfPointEquals) {
                countPoints++;
            }
        }
        return countPoints;
    }

    private boolean isCountConnectedPointsValid(List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            int pointsConnectedByEdgeWithCurrent = countPointsConnectedByEdge(points, currentPoint);
            if (pointsConnectedByEdgeWithCurrent != countConnectedPointExpected) {
                return false;
            }
        }
        return true;
    }

    private boolean isDistanceBetweenConnectedPointsEquals(List<Point> points, int expectedDistance) {
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                Point pointA = points.get(i);
                Point pointB = points.get(j);
                boolean isTwoCoordinatesOfPointEquals = pointLogic.isTwoCoordinatesOfPointEquals(pointA, pointB);
                int currentDistance = pointLogic.calculateDistance(pointA, pointB);
                if (i != j && isTwoCoordinatesOfPointEquals && currentDistance != expectedDistance) {
                    return false;
                }
            }
        }
        return true;
    }

}
