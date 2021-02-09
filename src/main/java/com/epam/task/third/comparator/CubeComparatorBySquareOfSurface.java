package com.epam.task.third.comparator;

import com.epam.task.third.entity.CubeParameters;
import com.epam.task.third.entity.observable.CubeObservable;

import java.util.Comparator;

public class CubeComparatorBySquareOfSurface implements Comparator<CubeObservable> {
    public int compare(CubeObservable firstCube, CubeObservable secondCube) {
        CubeParameters firstCubeParameters = firstCube.getParameters();
        CubeParameters secondCubeParameters = secondCube.getParameters();
        int firstCubeSquareOfSurface = firstCubeParameters.getSquareOfSurface();
        int secondCubeSquareOfSurface = secondCubeParameters.getSquareOfSurface();
        return Integer.compare(firstCubeSquareOfSurface, secondCubeSquareOfSurface);
    }
}
