package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/rotate-image/">https://leetcode.com/problems/rotate-image/</a>
 */
public class No48RotateImage {

  /**
   * time: O()
   * space: O()
   */
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        swap(matrix, i, j, j, i);
      }
    }
    for (int j = 0; j < n / 2; j++) {
      for (int i = 0; i < n; i++) {
        swap(matrix, i, j, i, n - 1 - j);
      }
    }
  }

  private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
    int tmp = matrix[i1][j1];
    matrix[i1][j1] = matrix[i2][j2];
    matrix[i2][j2] = tmp;
  }
}
