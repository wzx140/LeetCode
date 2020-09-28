package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No1288RemoveCoveredIntervalsTest {

  private final int[][] intervals1 = new int[][]{{1, 4}, {3, 6}, {2, 8}};
  private final int[][] intervals2 = new int[][]{{1, 2}, {1, 4}, {3, 4}};

  @Test
  public void removeCoveredIntervals() {
    No1288RemoveCoveredIntervals solution = new No1288RemoveCoveredIntervals();
    assertEquals(2, solution.removeCoveredIntervals(intervals1));
    assertEquals(1, solution.removeCoveredIntervals(intervals2));
  }
}