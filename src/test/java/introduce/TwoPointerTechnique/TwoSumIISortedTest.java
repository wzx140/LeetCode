package introduce.TwoPointerTechnique;

import org.junit.Test;
import per.wzx.introduce.TwoPointerTechnique.TwoSumIISorted;

import static org.junit.Assert.*;

public class TwoSumIISortedTest {
    private int[] a = {2, 7, 11, 15};
    private int target = 9;
    private TwoSumIISorted twoSumIISorted = new TwoSumIISorted();

    @Test
    public void twoSum1Test() {
        int[] res = twoSumIISorted.twoSum1(a, target);
        assertArrayEquals(new int[]{1, 2}, res);
    }

    @Test
    public void twoSum2Test() {
        int[] res = twoSumIISorted.twoSum2(a, target);
        assertArrayEquals(new int[]{1, 2}, res);
    }

    @Test
    public void twoSum3Test() {
        int[] res = twoSumIISorted.twoSum2(a, target);
        assertArrayEquals(new int[]{1, 2}, res);
    }
}