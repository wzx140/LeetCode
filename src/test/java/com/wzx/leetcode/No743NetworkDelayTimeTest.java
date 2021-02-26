package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No743NetworkDelayTimeTest {

  private final int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
  private final int[][] times2 = {{1, 2, 1}};

  @Test
  public void networkDelayTime1() {
    No743NetworkDelayTime solution = new No743NetworkDelayTime();
    assertEquals(2, solution.networkDelayTime1(times1, 4, 2));
    assertEquals(1, solution.networkDelayTime1(times2, 2, 1));
    assertEquals(-1, solution.networkDelayTime1(times2, 2, 2));
  }

  @Test
  public void networkDelayTime2() {
    No743NetworkDelayTime solution = new No743NetworkDelayTime();
    assertEquals(2, solution.networkDelayTime2(times1, 4, 2));
    assertEquals(1, solution.networkDelayTime2(times2, 2, 1));
    assertEquals(-1, solution.networkDelayTime2(times2, 2, 2));
  }
}