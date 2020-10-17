package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author wzx
 */
public class No4TwoDimensionalArraySearch {

  /**
   * 二分搜索。二维数组中每一行加一个相邻列组成的L型序列是有序的，从左下角的元素开始和target比较可以每次排除一列或者一行
   * <p>
   * time: O(m+n)
   * space: O(n)
   */
  public boolean findNumberIn2DArray(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) return false;

    int rowSize = matrix.length;
    int colSize = matrix[0].length;

    // 当前所在的L序列
    int row = rowSize - 1;
    int col = 0;

    while (col < colSize && row >= 0) {
      if (matrix[row][col] < target) {
        col++;
      } else if (matrix[row][col] > target) {
        row--;
      } else {
        return true;
      }
    }

    return false;
  }
}
