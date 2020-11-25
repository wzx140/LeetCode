package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No435NonOverlappingIntervalsTest {

  private final int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
  private final int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
  private final int[][] intervals3 = {{1, 2}, {2, 3}};

  @Test
  public void eraseOverlapIntervals() {
    No435NonOverlappingIntervals solution = new No435NonOverlappingIntervals();
    assertEquals(1, solution.eraseOverlapIntervals(intervals1));
    assertEquals(2, solution.eraseOverlapIntervals(intervals2));
    assertEquals(0, solution.eraseOverlapIntervals(intervals3));
  }
}