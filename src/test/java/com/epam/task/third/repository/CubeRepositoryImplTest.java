package com.epam.task.third.repository;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Point;
import com.epam.task.third.specifications.CubeSpecificationByVolume;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CubeRepositoryImplTest {

    private final CubeRepositoryImpl repository = CubeRepositoryImpl.getInstance();

    public static final List<Point> FIRST_CUBE_LIST_POINTS = Arrays.asList(
            new Point(0, 0, 0), new Point(0, 0, 2), new Point(0, 2, 0),
            new Point(0, 2, 2), new Point(2, 0, 0), new Point(2, 0, 2),
            new Point(2, 2, 0), new Point(2, 2, 2));
    public static final Cube CUBE_FIRST = new Cube(FIRST_CUBE_LIST_POINTS);

    public static final List<Point> SECOND_CUBE_LIST_POINTS = Arrays.asList(
            new Point(0, 0, 0), new Point(0, 0, 4), new Point(0, 4, 0),
            new Point(0, 4, 4), new Point(4, 0, 0), new Point(4, 0, 4),
            new Point(4, 4, 0), new Point(4, 4, 4));
    public static final Cube CUBE_SECOND = new Cube(SECOND_CUBE_LIST_POINTS);

    private static final List<Cube> ALL_CUBES = Arrays.asList(CUBE_FIRST,CUBE_SECOND);
    private static final List<Cube> EXPECTED_CUBES = Arrays.asList(CUBE_FIRST);

    private static int MIN_VOLUME = 5;
    private static int MAX_VOLUME = 8;

    @Test
    public void testQueryShouldReturnFirstCubeWhenMinVolumeIsFiveAndMaxVolumeIsEight(){
        //given
        repository.addAllCubes(ALL_CUBES);
        CubeSpecificationByVolume specification = new CubeSpecificationByVolume(MIN_VOLUME,MAX_VOLUME);
        //when
        Map<Integer, Cube> actualAsMap = repository.query(specification);
        List<Cube> actualAsList = new ArrayList<Cube>(actualAsMap.values());
        //then
        Assert.assertEquals(EXPECTED_CUBES,actualAsList);
    }


}
