package com.epam.task.third.repository;

import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.observable.IdGenerator;
import com.epam.task.third.specifications.Specification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CubeRepositoryImpl implements Repository<Cube> {

    private static CubeRepositoryImpl instance;
    private Map<Integer, Cube> repository;
    private IdGenerator idGenerator;

    private CubeRepositoryImpl() {
        this.repository = new HashMap<Integer, Cube>();
        this.idGenerator = new IdGenerator();
    }

    public static CubeRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CubeRepositoryImpl();
        }
        return instance;
    }

    public void add(Cube cube) {
        repository.put(idGenerator.generateId(), cube);
    }

    public void update(Integer id, Cube cube) {
        repository.replace(id, cube);
    }

    public void remove(Integer id) {
        repository.remove(id);
    }

    public void addAllCubes(List<Cube> cubes) {
        for (Cube currentCube : cubes) {
            repository.put(idGenerator.generateId(), currentCube);
        }
    }

    public Map<Integer, Cube> query(Specification specification) {
        IdGenerator idGeneratorSpecifiedMap = new IdGenerator();
        Map<Integer, Cube> specifiedCubes = new HashMap<Integer, Cube>();
        List<Cube> listOfCubes = new ArrayList<Cube>(repository.values());
        for (Cube currentCube : listOfCubes) {
            if (specification.specified(currentCube)) {
                specifiedCubes.put(idGeneratorSpecifiedMap.generateId(), currentCube);
            }
        }
        return specifiedCubes;
    }
}
