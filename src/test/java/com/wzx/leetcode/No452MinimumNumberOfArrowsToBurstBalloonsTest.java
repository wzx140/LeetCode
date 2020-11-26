package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No452MinimumNumberOfArrowsToBurstBalloonsTest {

  private final int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
  private final int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
  private final int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
  private final int[][] points4 = {{1, 2}};
  private final int[][] points5 = {{2, 3}, {2, 3}};

  @Test
  public void findMinArrowShots() {
    No452MinimumNumberOfArrowsToBurstBalloons solution = new No452MinimumNumberOfArrowsToBurstBalloons();
    assertEquals(2, solution.findMinArrowShots(points1));
    assertEquals(4, solution.findMinArrowShots(points2));
    assertEquals(2, solution.findMinArrowShots(points3));
    assertEquals(1, solution.findMinArrowShots(points4));
    assertEquals(1, solution.findMinArrowShots(points5));
  }
}