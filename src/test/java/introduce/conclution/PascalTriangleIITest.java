package introduce.conclution;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PascalTriangleIITest {
    private PascalTriangleII triangle = new PascalTriangleII();

    @Test
    public void getRowTest() {
        List<Integer> row1 = triangle.getRow(3);
        assertEquals(4, row1.size());
        assertEquals(1, row1.get(0).intValue());
        assertEquals(3, row1.get(1).intValue());
        assertEquals(3, row1.get(2).intValue());
        assertEquals(1, row1.get(3).intValue());

        List<Integer> row2 = triangle.getRow(4);
        assertEquals(5, row2.size());
        assertEquals(1, row2.get(0).intValue());
        assertEquals(4, row2.get(1).intValue());
        assertEquals(6, row2.get(2).intValue());
        assertEquals(4, row2.get(3).intValue());
        assertEquals(1, row2.get(4).intValue());
    }
}