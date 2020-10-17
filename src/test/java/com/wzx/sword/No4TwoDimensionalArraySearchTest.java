package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No4TwoDimensionalArraySearchTest {

  private final int[][] array1 = {{1, 4, 7, 11, 15},
          {2, 5, 8, 12, 19},
          {3, 6, 9, 16, 22},
          {10, 13, 14, 17, 24},
          {18, 21, 23, 26, 30}};

  private final int[][] array2 = {{1, 1}};

  @Test
  public void findNumberIn2DArray() {
    No4TwoDimensionalArraySearch solution = new No4TwoDimensionalArraySearch();
    assertTrue(solution.findNumberIn2DArray(array1, 5));
    assertFalse(solution.findNumberIn2DArray(array1, 20));
    assertFalse(solution.findNumberIn2DArray(array2, 2));
  }
}