package com.epam.task.third.comparators;

import com.epam.task.third.comparator.CubeComparatorByVolume;
import com.epam.task.third.entity.Point;
import com.epam.task.third.entity.observable.CubeObservable;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CubeComparatorByVolumeTest {

    public static final List<Point> SMALLER_CUBE_LIST_POINTS = Arrays.asList(
            new Point(0, 0, 0), new Point(0, 0, 2), new Point(0, 2, 0),
            new Point(0, 2, 2), new Point(2, 0, 0), new Point(2, 0, 2),
            new Point(2, 2, 0), new Point(2, 2, 2));
    public static final CubeObservable SMALLER_CUBE = new CubeObservable(SMALLER_CUBE_LIST_POINTS);

    public static final List<Point> LARGER_CUBE_LIST_POINTS = Arrays.asList(
            new Point(0, 0, 0), new Point(0, 0, 4), new Point(0, 4, 0),
            new Point(0, 4, 4), new Point(4, 0, 0), new Point(4, 0, 4),
            new Point(4, 4, 0), new Point(4, 4, 4));
    public static final CubeObservable LARGER_CUBE = new CubeObservable(LARGER_CUBE_LIST_POINTS);



    @Test
    public void testCompareShouldReturnMinusOneWhenSecondVolumeLargerThenFirst(){
        //given
        CubeComparatorByVolume comparator = new CubeComparatorByVolume();
        //when
        int actual = comparator.compare(SMALLER_CUBE, LARGER_CUBE);
        //then
        Assert.assertEquals(-1,actual);
    }

    @Test
    public void testCompareShouldReturnZeroWhenFirstVolumeAndSecondSame(){
        //given
        CubeComparatorByVolume comparator = new CubeComparatorByVolume();
        //when
        int actual = comparator.compare(SMALLER_CUBE, SMALLER_CUBE);
        //then
        Assert.assertEquals(0,actual);
    }

    @Test
    public void testCompareShouldReturnOneWhenFirstVolumeLargerThenSecond(){
        //given
        CubeComparatorByVolume comparator = new CubeComparatorByVolume();
        //when
        int actual = comparator.compare(LARGER_CUBE, SMALLER_CUBE);
        //then
        Assert.assertEquals(1,actual);
    }
}
