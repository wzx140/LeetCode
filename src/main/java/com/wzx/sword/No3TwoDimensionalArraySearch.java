package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e
 *
 * @author wzx
 */
public class No3TwoDimensionalArraySearch {

  /**
   * 二分搜索。二维数组中每一行加一个相邻列组成的L型序列是有序的，从左下角的元素开始和target比较可以每次排除一列或者一行
   *
   * time: O(m+n)
   * space: O(n)
   */
  public static boolean Find(int target, int[][] array) {
    if (array.length == 0 || array[0].length == 0) return false;

    int rowSize = array.length;
    int colSize = array[0].length;

    // 当前所在的L序列
    int col = 0;
    int row = rowSize - 1;

    while (col < colSize && row >= 0) {
      if (array[col][row] < target) {
        col++;
      } else if (array[col][row] > target) {
        row--;
      } else {
        return true;
      }
    }

    return false;
  }
}
