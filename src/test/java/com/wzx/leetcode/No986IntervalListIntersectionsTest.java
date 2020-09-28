package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No986IntervalListIntersectionsTest {

  private final int[][] interval1 = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
  private final int[][] interval2 = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
  private final int[][] res = {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}};

  @Test
  public void intervalIntersection() {
    No986IntervalListIntersections solution = new No986IntervalListIntersections();
    assertArrayEquals(res, solution.intervalIntersection(interval1, interval2));
  }
}