package com.epam.task.third.comparator;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.CubeParameters;
import com.epam.task.third.entity.observable.CubeObservable;

import java.util.Comparator;

public class CubeComparatorByVolume implements Comparator<CubeObservable> {
    public int compare(CubeObservable firstCube, CubeObservable secondCube) {
        CubeParameters firstCubeParameters = firstCube.getParameters();
        CubeParameters secondCubeParameters = secondCube.getParameters();
        int firstCubeVolume = firstCubeParameters.getVolume();
        int secondCubeVolume = secondCubeParameters.getVolume();
        return Integer.compare(firstCubeVolume, secondCubeVolume);
    }
}
