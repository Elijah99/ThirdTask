package com.epam.task.third.specifications;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.logic.CubeLogic;

public class CubeSpecificationBySquareOfSurface implements Specification {
    private int minSquareOfSurface;
    private int maxSquareOfSurface;
    private CubeLogic cubeLogic;

    public CubeSpecificationBySquareOfSurface(int minSquareOfSurface, int maxSquareOfSurface) {
        this.minSquareOfSurface = minSquareOfSurface;
        this.maxSquareOfSurface = maxSquareOfSurface;
        this.cubeLogic = new CubeLogic();
    }

    public boolean specified(Cube cube) {
        int currentSquareOfSurface = cubeLogic.calculateSquareOfCubeSurface(cube);
        return currentSquareOfSurface >= minSquareOfSurface && currentSquareOfSurface <= maxSquareOfSurface;
    }
}
