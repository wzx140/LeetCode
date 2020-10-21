package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No454FourSum2Test {

  private final int[] A = {1, 2};
  private final int[] B = {-2, -1};
  private final int[] C = {-1, 2};
  private final int[] D = {0, 2};

  @Test
  public void fourSumCount() {
    No454FourSum2 solution = new No454FourSum2();
    assertEquals(2, solution.fourSumCount(A, B, C, D));
  }
}