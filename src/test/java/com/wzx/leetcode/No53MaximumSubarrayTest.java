package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No53MaximumSubarrayTest {

  private final int[] array1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
  private final int[] array2 = {1};
  private final int[] array3 = {0};
  private final int[] array4 = {-1};
  private final int[] array5 = {-2147483647};

  @Test
  public void maxSubArray1() {
    No53MaximumSubarray solution = new No53MaximumSubarray();
    assertEquals(6, solution.maxSubArray1(array1));
    assertEquals(1, solution.maxSubArray1(array2));
    assertEquals(0, solution.maxSubArray1(array3));
    assertEquals(-1, solution.maxSubArray1(array4));
    assertEquals(-2147483647, solution.maxSubArray1(array5));
  }

  @Test
  public void maxSubArray2() {
    No53MaximumSubarray solution = new No53MaximumSubarray();
    assertEquals(6, solution.maxSubArray2(array1));
    assertEquals(1, solution.maxSubArray2(array2));
    assertEquals(0, solution.maxSubArray2(array3));
    assertEquals(-1, solution.maxSubArray2(array4));
    assertEquals(-2147483647, solution.maxSubArray2(array5));
  }
}