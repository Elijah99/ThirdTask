package com.epam.task.third.specifications;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.logic.CubeLogic;

public class CubeSpecificationBySquareOfSide implements Specification {
    private int minSquareOfSide;
    private int maxSquareOfSide;
    private CubeLogic cubeLogic;

    public CubeSpecificationBySquareOfSide(int minSquareOfSide, int maxSquareOfSide) {
        this.minSquareOfSide = minSquareOfSide;
        this.maxSquareOfSide = maxSquareOfSide;
        this.cubeLogic = new CubeLogic();
    }

    public boolean specified(Cube cube) {
        int currentSquareOfSide = cubeLogic.calculateSquareOfSide(cube);
        return currentSquareOfSide >= minSquareOfSide && currentSquareOfSide <= maxSquareOfSide;
    }
}
