package com.epam.task.third.creator;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entity.Cube;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class CubeCreator {

    private DataReader dataReader;
    private CubeValidator cubeValidator;
    private DataParser dataParser;

    public CubeCreator(DataReader dataReader, CubeValidator cubeValidator, DataParser dataParser) {
        this.dataReader = dataReader;
        this.cubeValidator = cubeValidator;
        this.dataParser = dataParser;
    }

    public List<Cube> create(String filename) throws DataException {
        List<Cube> cubeList = new ArrayList<Cube>();
        try {
            List<String> cubeStringList = dataReader.readData(filename);
            for (int i = 0; i < cubeStringList.size(); i++) {
                String line = cubeStringList.get(i);
                if (cubeValidator.validateString(line)) {
                    Cube cube = dataParser.parseCube(line);
                    cubeList.add(cube);
                }
            }
        } catch (DataException e) {

        }
        return cubeList;
    }
}
