package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No773SlidingPuzzleTest {

  private final int[][] board1 = {{1, 2, 3}, {4, 0, 5}};
  private final int[][] board2 = {{1, 2, 3}, {5, 4, 0}};
  private final int[][] board3 = {{4, 1, 2}, {5, 0, 3}};
  private final int[][] board4 = {{3, 2, 4}, {1, 5, 0}};

  @Test
  public void slidingPuzzle() {
    No773SlidingPuzzle solution = new No773SlidingPuzzle();
    assertEquals(1, solution.slidingPuzzle(board1));
    assertEquals(-1, solution.slidingPuzzle(board2));
    assertEquals(5, solution.slidingPuzzle(board3));
    assertEquals(14, solution.slidingPuzzle(board4));
  }
}