package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No57NSumTest {

  private final int[][] res1 = new int[][]{{2, 3, 4}, {4, 5}};
  private final int[][] res2 = new int[][]{{1, 2, 3, 4, 5}, {4, 5, 6}, {7, 8}};

  @Test
  public void findContinuousSequence() {
    No57NSum solution = new No57NSum();
    assertArrayEquals(res1, solution.findContinuousSequence(9));
    assertArrayEquals(res2, solution.findContinuousSequence(15));
  }
}