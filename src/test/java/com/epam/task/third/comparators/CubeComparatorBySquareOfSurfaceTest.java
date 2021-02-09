package com.epam.task.third.comparators;

import com.epam.task.third.comparator.CubeComparatorBySquareOfSurface;
import com.epam.task.third.entity.observable.CubeObservable;
import org.junit.Assert;
import org.junit.Test;

public class CubeComparatorBySquareOfSurfaceTest {

    public static final CubeObservable SMALLER_CUBE = CubeComparatorByVolumeTest.SMALLER_CUBE;

    public static final CubeObservable LARGER_CUBE = CubeComparatorByVolumeTest.LARGER_CUBE;

    @Test
    public void testCompareShouldReturnMinusOneWhenSecondSquareOfSurfaceLargerThenFirst() {
        //given
        CubeComparatorBySquareOfSurface comparator = new CubeComparatorBySquareOfSurface();
        //when
        int actual = comparator.compare(SMALLER_CUBE, LARGER_CUBE);
        //then
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testCompareShouldReturnZeroWhenFirstSquareOfSurfaceAndSecondSame() {
        //given
        CubeComparatorBySquareOfSurface comparator = new CubeComparatorBySquareOfSurface();
        //when
        int actual = comparator.compare(SMALLER_CUBE, SMALLER_CUBE);
        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCompareShouldReturnOneWhenFirstSquareOfSurfaceLargerThenSecond() {
        //given
        CubeComparatorBySquareOfSurface comparator = new CubeComparatorBySquareOfSurface();
        //when
        int actual = comparator.compare(LARGER_CUBE, SMALLER_CUBE);
        //then
        Assert.assertEquals(1, actual);
    }

}
