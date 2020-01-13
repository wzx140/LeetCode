package introduce.array;

import org.junit.Test;
import per.wzx.introduce.array.FindPivotIndex;

import static org.junit.Assert.assertEquals;

public class FindPivotIndexTest {
    private int[] a = {1, 7, 3, 6, 5, 6};
    private int[] b = {1, 2, 3};
    private int[] c = {-1, -1, 0, 1, 1, 0};
    private FindPivotIndex findPivotIndex = new FindPivotIndex();

    @Test
    public void pivotIndex1Test() {
        int res1 = findPivotIndex.pivotIndex1(a);
        int res2 = findPivotIndex.pivotIndex1(b);
        int res3 = findPivotIndex.pivotIndex1(c);
        assertEquals(3, res1);
        assertEquals(-1,res2);
        assertEquals(5,res3);
    }

    @Test
    public void pivotIndex2Test() {
        int res1 = findPivotIndex.pivotIndex2(a);
        int res2 = findPivotIndex.pivotIndex2(b);
        int res3 = findPivotIndex.pivotIndex2(c);
        assertEquals(3, res1);
        assertEquals(-1,res2);
        assertEquals(5,res3);
    }
}