package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No56MergeIntervalsTest {

  private final int[][] intervals1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
  private final int[][] res1 = new int[][]{{1, 6}, {8, 10}, {15, 18}};
  private final int[][] intervals2 = new int[][]{{1, 4}, {4, 5}};
  private final int[][] res2 = new int[][]{{1, 5}};

  @Test
  public void merge() {
    No56MergeIntervals solution = new No56MergeIntervals();
    assertArrayEquals(res1, solution.merge(intervals1));
    assertArrayEquals(res2, solution.merge(intervals2));
  }
}