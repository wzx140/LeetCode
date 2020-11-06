package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class No29PrintMatrixClockwiseTest {

  private final int[][] matrix1 = new int[][]{
          {1, 2, 3, 4},
          {5, 6, 7, 8},
          {9, 10, 11, 12},
          {13, 14, 15, 16}
  };
  private final int[] res1 = {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10};

  private final int[][] matrix2 = new int[][]{
          {1},
          {2},
          {3},
          {4},
          {5}
  };
  private final int[] res2 = {1, 2, 3, 4, 5};

  @Test
  public void printMatrix() {
    No29PrintMatrixClockwise solution = new No29PrintMatrixClockwise();
    assertArrayEquals(res1, solution.spiralOrder(matrix1));
    assertArrayEquals(res2, solution.spiralOrder(matrix2));
  }
}