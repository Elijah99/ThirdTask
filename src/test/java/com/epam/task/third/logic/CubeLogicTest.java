package com.epam.task.third.logic;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CubeLogicTest {

    public static final List<Point> LIST_POINTS_OF_CUBE_CORRECT = Arrays.asList(
            new Point(0, 0, 0), new Point(0, 0, 2), new Point(0, 2, 0),
            new Point(0, 2, 2), new Point(2, 0, 0), new Point(2, 0, 2),
            new Point(2, 2, 0), new Point(2, 2, 2));
    public static final Cube CUBE_CORRECT = new Cube(LIST_POINTS_OF_CUBE_CORRECT);


    @Test
    public void testCalculateSquareShouldCalculateSquareWhenCubeIsValid() {
        //given
        CubeLogic logic = new CubeLogic();
        //when
        int square = logic.calculateVolume(CUBE_CORRECT);
        //then
        Assert.assertEquals(8, square);
    }

    @Test
    public void testIsBaseOfCubeOnPlaneXShouldReturnTrueWhenBaseOfInputCubeOnPlaneX() {
        //given
        CubeLogic logic = new CubeLogic();
        //when
        boolean actual = logic.isBaseOfCubeOnPlaneX(CUBE_CORRECT);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsBaseOfCubeOnPlaneYShouldReturnTrueWhenBaseOfInputCubeOnPlaneY() {
        //given
        CubeLogic logic = new CubeLogic();
        //when
        boolean actual = logic.isBaseOfCubeOnPlaneY(CUBE_CORRECT);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsBaseOfCubeOnPlaneZShouldReturnTrueWhenBaseOfInputCubeOnPlaneZ() {
        //given
        CubeLogic logic = new CubeLogic();
        //when
        boolean actual = logic.isBaseOfCubeOnPlaneZ(CUBE_CORRECT);
        //then
        Assert.assertTrue(actual);
    }


}
