package com.epam.task.third.creator;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public static final String DELIMITER_SPACE = " ";
    public static final String DELIMITER_COMMA = ",";

    public Point parsePoint(String string){
        string = string.trim();
        String[] values = string.split(DELIMITER_SPACE);

        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        int z = Integer.parseInt(values[2]);

        return new Point(x, y, z);
    }

    public Cube parseCube(String string){
        String[] points = string.split(DELIMITER_COMMA);
        List<Point> pointList = new ArrayList<Point>();
        for(int i = 0; i < points.length; i++){
            Point point = parsePoint(points[i]);
            pointList.add(point);
        }
        Cube cube = new Cube(pointList);
        return cube;
    }
}
