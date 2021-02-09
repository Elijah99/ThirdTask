package com.epam.task.third.entity;

import java.util.Objects;

public class CubeParameters {
    private int volume;
    private int squareOfSurface;
    private int squareOfSide;

    public CubeParameters(int volume, int squareOfSurface, int squareOfSide) {
        this.volume = volume;
        this.squareOfSurface = squareOfSurface;
        this.squareOfSide = squareOfSide;
    }


    public int getVolume() {
        return volume;
    }

    public int getSquareOfSurface() {
        return squareOfSurface;
    }

    public int getSquareOfSide() {
        return squareOfSide;
    }

    @Override
    public String toString() {
        return "CubeParameters{" +
                "volume=" + volume +
                ", squareOfSurface=" + squareOfSurface +
                ", squareOfSide=" + squareOfSide +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CubeParameters)) {
            return false;
        }
        CubeParameters that = (CubeParameters) o;
        return volume == that.volume &&
                squareOfSurface == that.squareOfSurface &&
                squareOfSide == that.squareOfSide;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(volume) + Integer.hashCode(squareOfSide) + Integer.hashCode(squareOfSurface);
    }
}
