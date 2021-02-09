package com.epam.task.third.specifications;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.logic.CubeLogic;

public class CubeSpecificationByVolume implements Specification {

    private int minVolume;
    private int maxVolume;
    private CubeLogic cubeLogic;

    public CubeSpecificationByVolume(int minVolume, int maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.cubeLogic = new CubeLogic();
    }

    public boolean specified(Cube cube) {
        int currentVolume = cubeLogic.calculateVolume(cube);
        return currentVolume >= minVolume && currentVolume <= maxVolume;
    }
}
