package com.epam.task.third.creator;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class DataParserTest {

    public static final String STRING_FIGURE = "1 2 3, 1 2 3";
    public static final  Cube FIGURE_EXPECTED = new Cube(new Point(1,2,3), new Point(1,2,3));

    @Test
    public void testParseFigureShouldShouldReturnCubeWhenInputStringIsValid(){
        //given
        DataParser dataParser = new DataParser();
        //when
        Cube cube = dataParser.parseCube(STRING_FIGURE);
        //then
        Assert.assertEquals(FIGURE_EXPECTED,cube);
    }
}
