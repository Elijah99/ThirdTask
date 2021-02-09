package com.epam.task.third.observer;

import com.epam.task.third.comparators.CubeComparatorByVolumeTest;
import com.epam.task.third.entity.CubeParameters;
import com.epam.task.third.entity.observable.CubeObservable;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CubeObserverTest {

    private final CubeObserver cubeObserver = CubeObserver.getInstance();
    private static final CubeObservable CUBE_VALID = CubeComparatorByVolumeTest.SMALLER_CUBE;
    private static final int VOLUME_EXPECTED = 8;
    private static final int SQUARE_OF_SURFACE_EXPECTED = 32;
    private static final int SQUARE_OF_SIDE_EXPECTED = 4;

    @Test
    public void testUpdateShould() {
        //given
        CUBE_VALID.attach(cubeObserver);
        Map<Integer, CubeParameters> expected = new HashMap<Integer, CubeParameters>();
        CubeParameters expectedCubeParameters = new CubeParameters(VOLUME_EXPECTED, SQUARE_OF_SURFACE_EXPECTED, SQUARE_OF_SIDE_EXPECTED);
        expected.put(0, expectedCubeParameters);
        //when
        Map<Integer, CubeParameters> actual = cubeObserver.getCubeParameters();
        //then
        Assert.assertEquals(expected, actual);
    }
}
