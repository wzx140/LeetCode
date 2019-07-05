package main.java.introduce.TwoPointerTechnique;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayPartitionITest {
    private int[] a = {1, 4, 3, 2};
    private int[] b = {2, 3, 1, 3, 6, 2};
    private ArrayPartitionI arrayPartitionI = new ArrayPartitionI();

    @Test
    public void arrayPairSumTest() {
        int res1 = arrayPartitionI.arrayPairSum(a);
        int res2 = arrayPartitionI.arrayPairSum(b);
        assertEquals(4, res1);
        assertEquals(6, res2);
    }
}