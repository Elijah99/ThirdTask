package com.epam.task.third.creator;

import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entity.Cube;
import com.epam.task.third.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class CubeCreatorTest {

    public static final String FILENAME = "./src/test/resources/input.txt";
    public static final List<String> CUBE_LIST_STRINGS_CORRECT = Arrays.asList("1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3\n",
            "1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3\n",
            "1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3,1 2 3");
    public static final List<Point> CUBE_LIST_POINTS_CORRECT = Arrays.asList(
            new Point(1, 2, 3), new Point(1, 2, 3), new Point(1, 2, 3),
            new Point(1, 2, 3), new Point(1, 2, 3), new Point(1, 2, 3),
            new Point(1, 2, 3), new Point(1, 2, 3));
    public static final List<Cube> CUBE_LIST_EXPECTED = Arrays.asList(new Cube(CUBE_LIST_POINTS_CORRECT),
            new Cube(CUBE_LIST_POINTS_CORRECT), new Cube(CUBE_LIST_POINTS_CORRECT));

    @Test
    public void testCreateCube() throws DataException {
        //given
        DataReader dataReader = Mockito.mock(DataReader.class);
        when(dataReader.readData(anyString())).thenReturn(CUBE_LIST_STRINGS_CORRECT);
        CubeValidator validator = new CubeValidator();
        DataParser parser = new DataParser();
        CubeCreator creator = new CubeCreator(dataReader, validator, parser);

        //when
        List<Cube> actual = creator.create(FILENAME);

        //then
        Assert.assertEquals(CUBE_LIST_EXPECTED, actual);
    }
}
