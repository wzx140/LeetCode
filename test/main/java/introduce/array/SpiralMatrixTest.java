package main.java.introduce.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SpiralMatrixTest {
    private int[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    private int[][] b = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
    };
    private SpiralMatrix spiralMatrix = new SpiralMatrix();

    @Test
    public void spiralOrderTest() {
        List<Integer> res1 = spiralMatrix.spiralOrder(a);
        List<Integer> res2 = spiralMatrix.spiralOrder(b);
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), res1);
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), res2);
    }
}