package com.epam.task.third.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {


    public List<String> readData(String filename) throws DataException {
        String string = "";
        List<String> stringList = new ArrayList<String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            int character = -1;
            while ((character = fileInputStream.read()) != -1) {
                if (character == '\n') {
                    stringList.add(string);
                    string = "";
                } else {
                    string += (char) character;
                }
            }

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
        stringList.add(string);
        return stringList;
    }
}
