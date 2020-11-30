package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No52NQueens2Test {

  @Test
  public void totalNQueens() {
    No52NQueens2 solution = new No52NQueens2();
    assertEquals(2, solution.totalNQueens(4));
    assertEquals(1, solution.totalNQueens(1));
  }
}