package main.java.introduce.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestNumberAtLeastTwiceofOthersTest {
    private int[] a = { 0, 0, 4, 3 };
    private int[] b = {3, 6, 1, 0};
    private int[] c = {1, 2, 3, 4};
    private LargestNumberAtLeastTwiceofOthers largestNumberAtLeastTwiceofOthers = new LargestNumberAtLeastTwiceofOthers();

    @Test
    public void dominantIndexTest() {
        int res1 = largestNumberAtLeastTwiceofOthers.dominantIndex(a);
        int res2 = largestNumberAtLeastTwiceofOthers.dominantIndex(b);
        int res3 = largestNumberAtLeastTwiceofOthers.dominantIndex(c);
        assertEquals(-1,res1);
        assertEquals(1,res2);
        assertEquals(-1,res3);
    }
}