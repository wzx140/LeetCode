package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/n-queens-ii/">https://leetcode.com/problems/n-queens-ii/</a>
 * @author wzx
 */
public class No52NQueens2 {
  private boolean[] colSet = null;
  private boolean[] diagonalSet = null;
  private boolean[] antiDiagonalSet = null;
  private int cnt = 0;

  /**
   * 回溯
   * <p>
   * time: O(n!)
   * space: O(n)
   */
  public int totalNQueens(int n) {
    // 每列是否有皇后
    colSet = new boolean[n];
    // 每个左上斜线是否有皇后
    diagonalSet = new boolean[2 * n - 1];
    // 每个右上斜线是否有皇后
    antiDiagonalSet = new boolean[2 * n - 1];

    cnt = 0;
    recursion(0, n);
    return cnt;
  }

  private void recursion(int row, int n) {
    if (row == n) {
      cnt++;
      return;
    }

    for (int col = 0; col < n; col++) {
      if (valid(row, col, n)) {
        setVisit(row, col, n, true);
        recursion(row + 1, n);
        setVisit(row, col, n, false);
      }
    }
  }

  private boolean valid(int row, int col, int n) {
    return !colSet[col] && !diagonalSet[col + row] && !antiDiagonalSet[row - col + n - 1];
  }

  private void setVisit(int row, int col, int n, boolean visit) {
    colSet[col] = visit;
    diagonalSet[col + row] = visit;
    antiDiagonalSet[row - col + n - 1] = visit;
  }
}
