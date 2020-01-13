package introduce.array;

import org.junit.Test;
import per.wzx.introduce.array.PlusOne;

import static org.junit.Assert.*;

public class PlusOneTest {
    private PlusOne plusOne = new PlusOne();
    private int[] a = {1, 2, 3, 4};
    private int[] b = {1, 2, 3};
    private int[] c = {4, 3, 2, 1};


    @Test
    public void plusOne1Test() {
        int[] res1 = plusOne.plusOne1(a);
        int[] res2 = plusOne.plusOne1(b);
        int[] res3 = plusOne.plusOne1(c);
        assertArrayEquals(new int[]{1, 2, 3, 5}, res1);
        assertArrayEquals(new int[]{1, 2, 4}, res2);
        assertArrayEquals(new int[]{4, 3, 2, 2}, res3);
    }

    @Test
    public void plusOne2Test() {
        int[] res1 = plusOne.plusOne2(a);
        int[] res2 = plusOne.plusOne2(b);
        int[] res3 = plusOne.plusOne2(c);
        assertArrayEquals(new int[]{1, 2, 3, 5}, res1);
        assertArrayEquals(new int[]{1, 2, 4}, res2);
        assertArrayEquals(new int[]{4, 3, 2, 2}, res3);
    }
}