package com.epam.task.third.logic;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CubeLogicTest {

    public static final Point POINT_A = new Point(1, 1, 1);
    public static final Point POINT_B = new Point(3, 1, 1);
    public static final List<Point> CUBE_POINT_LIST_CORRECT = Arrays.asList(
            new Point(0, 0, 0), new Point(0, 0, 2), new Point(0, 2, 0),
            new Point(0, 2, 2), new Point(2, 0, 0), new Point(2, 0, 2),
            new Point(2, 2, 0), new Point(2, 2, 2));
    public static final Cube CUBE = new Cube(CUBE_POINT_LIST_CORRECT);

    @Test
    public void testCalculateDistance() {
        //given
        CubeLogic logic = new CubeLogic();
        //when
        int actual = logic.calculateDistance(POINT_A, POINT_B);
        //then
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testIsPointsAtLine() {
        //given
        CubeLogic logic = new CubeLogic();
        //when
        boolean actual = logic.isPointsAtLine(POINT_A, POINT_B);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testCalculateSquare() {
        //given
        CubeLogic logic = new CubeLogic();
        //when
        int square = logic.calculateVolume(CUBE);
        //then
        Assert.assertEquals(8, square);
    }

    @Test
    public void testIsBaseOfCubeOnPlaneX() {
        //given
        CubeLogic logic = new CubeLogic();
        //when
        boolean actual = logic.isBaseOfCubeOnPlaneX(CUBE);
        //then
        Assert.assertTrue(actual);
    }
}
