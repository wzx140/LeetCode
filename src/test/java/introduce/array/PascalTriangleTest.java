package introduce.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PascalTriangleTest {
    private PascalTriangle pascalTriangle = new PascalTriangle();

    @Test
    public void generateTest() {
        List<List<Integer>> res = pascalTriangle.generate(5);
        List<List<Integer>> expect = new ArrayList<List<Integer>>();
        expect.add(Arrays.asList(1));
        expect.add(Arrays.asList(1, 1));
        expect.add(Arrays.asList(1, 2, 1));
        expect.add(Arrays.asList(1, 3, 3, 1));
        expect.add(Arrays.asList(1, 4, 6, 4, 1));
        assertEquals(expect, res);
    }
}