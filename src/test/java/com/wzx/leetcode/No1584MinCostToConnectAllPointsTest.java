package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No1584MinCostToConnectAllPointsTest {

  private final int[][] points1 = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
  private final int[][] points2 = {{3, 12}, {-2, 5}, {-4, 1}};
  private final int[][] points3 = {{0, 0}, {1, 1}, {1, 0}, {-1, 1}};
  private final int[][] points4 = {{-1000000, -1000000}, {1000000, 1000000}};
  private final int[][] points5 = {{0, 0}};
  private final int[][] points6 = {{11, -6}, {9, -19}, {16, -13}, {4, -9}, {20, 4}, {20, 7}, {-9, 18}, {10, -15}, {-15, 3}, {6, 6}};

  @Test
  public void minCostConnectPoints1() {
    No1584MinCostToConnectAllPoints solution = new No1584MinCostToConnectAllPoints();
    assertEquals(20, solution.minCostConnectPoints1(points1));
    assertEquals(18, solution.minCostConnectPoints1(points2));
    assertEquals(4, solution.minCostConnectPoints1(points3));
    assertEquals(4000000, solution.minCostConnectPoints1(points4));
    assertEquals(0, solution.minCostConnectPoints1(points5));
    assertEquals(113, solution.minCostConnectPoints1(points6));
  }

  @Test
  public void minCostConnectPoints2() {
    No1584MinCostToConnectAllPoints solution = new No1584MinCostToConnectAllPoints();
    assertEquals(20, solution.minCostConnectPoints2(points1));
    assertEquals(18, solution.minCostConnectPoints2(points2));
    assertEquals(4, solution.minCostConnectPoints2(points3));
    assertEquals(4000000, solution.minCostConnectPoints2(points4));
    assertEquals(0, solution.minCostConnectPoints2(points5));
    assertEquals(113, solution.minCostConnectPoints2(points6));
  }
}