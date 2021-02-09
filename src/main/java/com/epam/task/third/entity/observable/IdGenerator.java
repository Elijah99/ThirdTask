package com.epam.task.third.entity.observable;

public class IdGenerator {
    public static final int START_VALUE = 0;

    private int id;

    public IdGenerator(int start) {
        this.id = start;
    }

    public IdGenerator() {
        this.id = START_VALUE;
    }

    public Integer generateId() {
        return id++;
    }
}
