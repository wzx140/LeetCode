package com.wzx.sword;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class No23PrintMatrixClockwiseTest {

  private final int[][] matrix1 = new int[][]{
          {1, 2, 3, 4},
          {5, 6, 7, 8},
          {9, 10, 11, 12},
          {13, 14, 15, 16}
  };
  private final List<Integer> res1 = Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);

  private final int[][] matrix2 = new int[][]{
          {1},
          {2},
          {3},
          {4},
          {5}
  };
  private final List<Integer> res2 = Arrays.asList(1, 2, 3, 4, 5);

  @Test
  public void printMatrix() {
    assertEquals(res1, No23PrintMatrixClockwise.printMatrix(matrix1));
    assertEquals(res2, No23PrintMatrixClockwise.printMatrix(matrix2));
  }
}