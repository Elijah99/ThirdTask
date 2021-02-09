package com.epam.task.third.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    public static final String FILENAME_VALID = "./src/test/resources/input.txt";
    public static final List<String> READ_DATA_VALID = Arrays.asList("1 2 3");

    @Test
    public void testReadDataShouldReadDataFromFileWhenFilenameIsValid() throws DataException {
        //given
        DataReader dataReader = new DataReader();
        //when
        List<String> actual = dataReader.readData(FILENAME_VALID);
        //then
        Assert.assertEquals(READ_DATA_VALID,actual);
    }
}
