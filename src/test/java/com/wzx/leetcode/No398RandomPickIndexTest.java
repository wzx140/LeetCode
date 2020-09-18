package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No398RandomPickIndexTest {

  private final int[] nums = new int[]{1, 2, 3, 3, 3, 3};

  @Test
  public void pick() {
    No398RandomPickIndex solution = new No398RandomPickIndex(nums);
    double[] res = new double[4];
    for (int i = 0; i < 10000; i++) {
      res[solution.pick(3) - 2]++;
    }
    double prob1 = res[0] / 10000;
    double prob2 = res[1] / 10000;
    double prob3 = res[2] / 10000;
    double prob4 = res[3] / 10000;
    assertEquals(0.25, prob1, 0.01);
    assertEquals(0.25, prob2, 0.01);
    assertEquals(0.25, prob3, 0.01);
    assertEquals(0.25, prob4, 0.01);
  }
}