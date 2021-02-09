package com.epam.task.third.data;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private final static Logger LOGGER = Logger.getLogger(DataReader.class);

    public List<String> readData(String filename) throws DataException {
        List<String> stringList = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        try {
            FileReader reader = new FileReader(filename);
            bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DataException("File read error", e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                    throw new DataException("BufferedReader close error", e);
                }
            }
        }
        return stringList;
    }
}
