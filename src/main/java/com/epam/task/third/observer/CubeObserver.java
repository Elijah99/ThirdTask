package com.epam.task.third.observer;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.CubeParameters;
import com.epam.task.third.entity.observable.IdGenerator;
import com.epam.task.third.logic.CubeLogic;

import java.util.HashMap;
import java.util.Map;

public class CubeObserver implements Observer {


    private static CubeObserver instance;
    private CubeLogic cubeLogic;
    private Map<Integer, CubeParameters> parameters;
    private IdGenerator idGenerator;

    private CubeObserver() {
        this.cubeLogic = new CubeLogic();
        this.parameters = new HashMap<Integer, CubeParameters>();
        this.idGenerator = new IdGenerator();
    }

    public static CubeObserver getInstance() {
        if (instance == null) {
            instance = new CubeObserver();
        }
        return instance;
    }

    public Map<Integer, CubeParameters> getCubeParameters() {
        return parameters;
    }

    public void update(Cube cube) {
        int squareOfSurface = cubeLogic.calculateSquareOfCubeSurface(cube);
        int squareOfSide = cubeLogic.calculateSquareOfSide(cube);
        int volume = cubeLogic.calculateVolume(cube);
        CubeParameters cubeParameters = new CubeParameters(volume, squareOfSurface, squareOfSide);
        parameters.put(idGenerator.generateId(), cubeParameters);
    }

}
