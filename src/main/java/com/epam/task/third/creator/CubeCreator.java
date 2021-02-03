package com.epam.task.third.creator;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Figure;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    public Cube create(String filename) throws DataException{
        throw new NotImplementedException();

    }
}
