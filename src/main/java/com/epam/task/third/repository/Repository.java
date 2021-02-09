package com.epam.task.third.repository;

import com.epam.task.third.specifications.Specification;

import java.util.Map;

public interface Repository<T> {
    void add(T objectToAdd);

    void update(Integer id, T objectToUpdate);

    void remove(Integer id);

    Map<Integer, T> query(Specification specification);
}
