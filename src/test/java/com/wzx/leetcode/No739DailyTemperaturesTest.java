package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No739DailyTemperaturesTest {

  private final int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
  private final int[] res = {1, 1, 4, 2, 1, 1, 0, 0};

  @Test
  public void dailyTemperatures() {
    No739DailyTemperatures solution = new No739DailyTemperatures();
    assertArrayEquals(res, solution.dailyTemperatures(temperatures));
  }
}