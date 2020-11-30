package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens-ii/
 *
 * @author wzx
 */
public class No52NQueens2 {

  private int cnt = 0;

  /**
   * 回溯
   * time: O(n!)
   * space: O(n)
   */
  public int totalNQueens(int n) {
    cnt = 0;
    List<char[]> board = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      char[] row = new char[n];
      Arrays.fill(row, '.');
      board.add(row);
    }

    recursion(0, board, n);
    return cnt;
  }

  private void recursion(int row, List<char[]> board, int n) {
    if (row == n) {
      cnt++;
      return;
    }

    for (int col = 0; col < n; col++) {
      if (isValid(board, row, col)) {
        board.get(row)[col] = 'Q';
        recursion(row + 1, board, n);
        board.get(row)[col] = '.';
      }
    }
  }

  private boolean isValid(List<char[]> board, int row, int col) {
    int n = board.size();
    // 垂直方向是否有其他皇后
    for (char[] boardRow : board) {
      if (boardRow[col] == 'Q') return false;
    }
    // 右上方是否有其他皇后
    for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
      if (board.get(r)[c] == 'Q') return false;
    }
    // 左上方是否有其他皇后
    for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
      if (board.get(r)[c] == 'Q') return false;
    }

    return true;
  }
}
