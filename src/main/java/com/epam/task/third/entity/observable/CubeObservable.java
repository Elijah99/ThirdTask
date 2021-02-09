package com.epam.task.third.entity.observable;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.CubeParameters;
import com.epam.task.third.entity.Point;
import com.epam.task.third.logic.CubeLogic;
import com.epam.task.third.observer.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CubeObservable extends Cube implements Observable {

    private List<Observer> observers;
    private CubeParameters parameters;

    public CubeObservable(List<Point> points) {
        super(points);
        parameters = calculateCubeParameters(points);
        this.observers = new ArrayList<Observer>();
    }

    public CubeObservable(Point... points) {
        super(points);
        List<Point> pointList = Arrays.asList(points);
        parameters = calculateCubeParameters(pointList);
        this.observers = new ArrayList<Observer>();
    }


    public void attach(Observer observer) {
        this.observers.add(observer);
        observer.update(this);
    }

    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    public CubeParameters getParameters() {
        return parameters;
    }

    private CubeParameters calculateCubeParameters(List<Point> points) {
        CubeLogic logic = new CubeLogic();
        Cube cube = new Cube(points);
        int volume = logic.calculateVolume(cube);
        int squareOfSurface = logic.calculateSquareOfCubeSurface(cube);
        int squareOfSide = logic.calculateSquareOfSide(cube);
        return new CubeParameters(volume, squareOfSurface, squareOfSide);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CubeObservable cubeObserved = (CubeObservable) o;
        return Objects.equals(observers, cubeObserved.observers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), observers);
    }
}
