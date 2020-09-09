package com.wzx.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8
 *
 * @author wzx
 */
public class No14RobotMovementRange {
  public static int movingCount(int threshold, int rows, int cols) {
    Set<Integer> visit = new HashSet<>(rows * cols);
    return recursion(threshold, 0, 0, rows, cols, visit);
  }

  /**
   * 递归深搜
   *
   * @param threshold 阈值
   * @param row       当前行号
   * @param col       当前列号
   * @param rows      总行数
   * @param cols      总列数
   * @param visit     已访问数组
   * @return 当前状态所能访问格子的数量
   */
  public static int recursion(int threshold, int row, int col, int rows, int cols, Set<Integer> visit) {
    if (row < 0 || row >= rows || col < 0 || col >= cols) return 0;
    int index = row * cols + col;
    if (visit.contains(index) || getSum(row) + getSum(col) > threshold) return 0;

    visit.add(index);
    return 1 + recursion(threshold, row + 1, col, rows, cols, visit)
            + recursion(threshold, row - 1, col, rows, cols, visit)
            + recursion(threshold, row, col + 1, rows, cols, visit)
            + recursion(threshold, row, col - 1, rows, cols, visit);
  }

  /**
   * 获得数位和
   */
  private static int getSum(int digit) {
    int sum = 0;
    while (digit != 0) {
      sum += (digit % 10);
      digit /= 10;
    }
    return sum;
  }

}
