package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No42TrappingRainWaterTest {

  private final int[] heights1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
  private final int[] heights2 = {4, 2, 0, 3, 2, 5};

  @Test
  public void trap1() {
    No42TrappingRainWater solution = new No42TrappingRainWater();
    assertEquals(6, solution.trap1(heights1));
    assertEquals(9, solution.trap1(heights2));
  }

  @Test
  public void trap2() {
    No42TrappingRainWater solution = new No42TrappingRainWater();
    assertEquals(6, solution.trap2(heights1));
    assertEquals(9, solution.trap2(heights2));
  }
}