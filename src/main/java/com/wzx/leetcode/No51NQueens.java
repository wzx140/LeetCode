package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/n-queens/
 *
 * @author wzx
 */
public class No51NQueens {

  /**
   * 回溯
   * <p>
   * time: O(n!)
   * space: O(n)
   */
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new LinkedList<>();
    List<char[]> board = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      char[] row = new char[n];
      Arrays.fill(row, '.');
      board.add(row);
    }

    recursion(0, board, n, res);
    return res;
  }

  private void recursion(int row, List<char[]> board, int n, List<List<String>> res) {
    if (row == n) {
      List<String> solution = board.stream()
              .map(String::new)
              .collect(Collectors.toList());
      res.add(solution);
      return;
    }

    for (int col = 0; col < n; col++) {
      if (isValid(board, row, col)) {
        board.get(row)[col] = 'Q';
        recursion(row + 1, board, n, res);
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
