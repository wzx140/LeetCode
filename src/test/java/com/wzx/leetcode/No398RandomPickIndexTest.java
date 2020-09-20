package com.wzx.leetcode;

import org.junit.Test;

import static com.wzx.common.Constant.RANDOM_SAMPLE_NUM;
import static org.junit.Assert.assertEquals;

public class No398RandomPickIndexTest {

  private final int[] nums = new int[]{1, 2, 3, 3, 3, 3};

  @Test
  public void pick() {
    No398RandomPickIndex solution = new No398RandomPickIndex(nums);
    double[] res = new double[4];
    for (int i = 0; i < RANDOM_SAMPLE_NUM; i++) {
      res[solution.pick(3) - 2]++;
    }
    double prob1 = res[0] / RANDOM_SAMPLE_NUM;
    double prob2 = res[1] / RANDOM_SAMPLE_NUM;
    double prob3 = res[2] / RANDOM_SAMPLE_NUM;
    double prob4 = res[3] / RANDOM_SAMPLE_NUM;
    assertEquals(0.25, prob1, 0.01);
    assertEquals(0.25, prob2, 0.01);
    assertEquals(0.25, prob3, 0.01);
    assertEquals(0.25, prob4, 0.01);
  }
}