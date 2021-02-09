package com.epam.task.third.comparator;

import com.epam.task.third.entity.CubeParameters;
import com.epam.task.third.entity.observable.CubeObservable;

import java.util.Comparator;

public class CubeComparatorBySquareOfSide implements Comparator<CubeObservable> {
    public int compare(CubeObservable firstCube, CubeObservable secondCube) {
        CubeParameters firstCubeParameters = firstCube.getParameters();
        CubeParameters secondCubeParameters = secondCube.getParameters();
        int firstCubeSquareOfSide = firstCubeParameters.getSquareOfSide();
        int secondCubeSquareOfSide = secondCubeParameters.getSquareOfSide();
        return Integer.compare(firstCubeSquareOfSide, secondCubeSquareOfSide);
    }
}
