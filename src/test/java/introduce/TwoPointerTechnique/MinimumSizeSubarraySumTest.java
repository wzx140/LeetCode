package introduce.TwoPointerTechnique;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumSizeSubarraySumTest {
    private MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
    private int[] a = {2, 3, 1, 2, 4, 3};
    private int[] b = {1, 4, 4};
    private int[] c = {1, 1};
    private int aValue = 2;
    private int bValue = 1;
    private int cValue = 0;

    @Test
    public void minSubArrayLen1Test() {
        assertEquals(aValue, solution.minSubArrayLen1(7, a));
        assertEquals(bValue, solution.minSubArrayLen1(4, b));
        assertEquals(cValue, solution.minSubArrayLen1(3, c));
    }

    @Test
    public void minSubArrayLen2Test() {
        assertEquals(aValue, solution.minSubArrayLen2(7, a));
        assertEquals(bValue, solution.minSubArrayLen2(4, b));
        assertEquals(cValue, solution.minSubArrayLen2(3, c));
    }

    @Test
    public void minSubArrayLen3Test() {
        assertEquals(aValue, solution.minSubArrayLen3(7, a));
        assertEquals(bValue, solution.minSubArrayLen3(4, b));
        assertEquals(cValue, solution.minSubArrayLen3(3, c));
    }
}