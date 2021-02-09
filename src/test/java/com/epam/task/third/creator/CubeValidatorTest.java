package com.epam.task.third.creator;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CubeValidatorTest {

    public static final List<Point> CUBE_LIST_POINTS_CORRECT = Arrays.asList(
            new Point(0, 0, 0), new Point(0, 0, 2), new Point(0, 2, 0),
            new Point(0, 2, 2), new Point(2, 0, 0), new Point(2, 0, 2),
            new Point(2, 2, 0), new Point(2, 2, 2));
    public static final Cube CUBE_CORRECT = new Cube(CUBE_LIST_POINTS_CORRECT);
    public static final String STRING_WITH_CORRECT_DATA = "1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3";

    public static final List<Point> LIST_POINTS_OF_CUBE_INCORRECT = Arrays.asList(
            new Point(1, -1, 2), new Point(7, 6, 2), new Point(1, 2, 2),
            new Point(4, 6, 2), new Point(-6, -4, -6), new Point(-6, 5, 1),
            new Point(2, 2, 0), new Point(2, 2, 2));
    public static final Cube CUBE_INCORRECT = new Cube(LIST_POINTS_OF_CUBE_INCORRECT);
    public static final String STRING_WITH_INCORRECT_DATA = "1 2 a,2 3,1 / 3,a 2 3,s ..,,, 3,1,1 2 3,1 2 3";

    @Test
    public void testIsCubeShouldReturnTrueWhenCubeIsCorrect(){
        //given
        CubeValidator validator = new CubeValidator();
        //when
        boolean actual = validator.isCube(CUBE_CORRECT);
        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void testIsCubeShouldReturnFalseWhenCubeIsIncorrect(){
        //given
        CubeValidator validator = new CubeValidator();
        //when
        boolean actual = validator.isCube(CUBE_INCORRECT);
        //then
        Assert.assertFalse(actual);

    }


    @Test
    public void testValidateStringShouldReturnTrueWhenStringIsCorrect(){
        //given
        CubeValidator cubeValidator = new CubeValidator();
        //when
        boolean actual = cubeValidator.validateString(STRING_WITH_CORRECT_DATA);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateStringShouldReturnFalseWhenStringIsIncorrect(){
        //given
        CubeValidator cubeValidator = new CubeValidator();
        //when
        boolean actual = cubeValidator.validateString(STRING_WITH_INCORRECT_DATA);
        //then
        Assert.assertFalse(actual);
    }
}
