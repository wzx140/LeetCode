package com.wzx.sword;

/**
 * @author wzx
 * @see <a href="https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8">https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8</a>
 */
public class No13RobotMovementRange {

  private final int[][] dict = {
          {1, 0},
          {-1, 0},
          {0, 1},
          {0, -1}
  };

  /**
   * 深搜
   * <p>
   * time: O(mn)
   * space: O(mn)
   */
  public int movingCount(int threshold, int rows, int cols) {
    return recursion(0, 0, rows, cols, new boolean[rows][cols], threshold);
  }

  private int recursion(int row, int col, int rows, int cols, boolean[][] visit, int threshold) {
    if (row < 0 || row >= rows || col < 0 || col >= cols) return 0;
    if (getSum(row) + getSum(col) > threshold) return 0;
    if (visit[row][col]) return 0;
    // 回溯
    int step = 1;
    visit[row][col] = true;
    for (int i = 0; i < 4; i++) {
      int nextRow = row + dict[i][0];
      int nextCol = col + dict[i][1];
      step += recursion(nextRow, nextCol, rows, cols, visit, threshold);
    }

    return step;
  }

  /**
   * 获得数位和
   */
  private int getSum(int digit) {
    int sum = 0;
    while (digit != 0) {
      sum += (digit % 10);
      digit /= 10;
    }
    return sum;
  }

}
