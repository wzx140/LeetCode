package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class No48RotateImageTest {

  private final int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  private final int[][] res1 = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
  private final int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
  private final int[][] res2 = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
  private final int[][] matrix3 = {{1}};
  private final int[][] res3 = {{1}};
  private final int[][] matrix4 = {{1, 2}, {3, 4}};
  private final int[][] res4 = {{3, 1}, {4, 2}};

  @Test
  public void rotate() {
    No48RotateImage solution = new No48RotateImage();
    solution.rotate(matrix1);
    assertArrayEquals(res1, matrix1);
    solution.rotate(matrix2);
    assertArrayEquals(res2, matrix2);
    solution.rotate(matrix3);
    assertArrayEquals(res3, matrix3);
    solution.rotate(matrix4);
    assertArrayEquals(res4, matrix4);
  }
}