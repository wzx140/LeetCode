package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/n-queens/">https://leetcode.com/problems/n-queens/</a>
 */
public class No51NQueens {
  private boolean[] colSet = null;
  private boolean[] diagonalSet = null;
  private boolean[] antiDiagonalSet = null;

  /**
   * 回溯
   * <p>
   * time: O(n!)
   * space: O(n)
   */
  public List<List<String>> solveNQueens(int n) {
    // 初始化棋盘
    List<char[]> board = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      char[] row = new char[n];
      Arrays.fill(row, '.');
      board.add(row);
    }
    // 每列是否有皇后
    colSet = new boolean[n];
    // 每个左上斜线是否有皇后
    diagonalSet = new boolean[2 * n - 1];
    // 每个右上斜线是否有皇后
    antiDiagonalSet = new boolean[2 * n - 1];

    List<List<String>> res = new LinkedList<>();
    recursion(0, n, board, res);
    return res;
  }

  private void recursion(int row, int n, List<char[]> board, List<List<String>> res) {
    if (row == n) {
      List<String> solution = board.stream()
              .map(String::new)
              .collect(Collectors.toList());
      res.add(solution);
      return;
    }

    for (int col = 0; col < n; col++) {
      if (valid(row, col, n)) {
        board.get(row)[col] = 'Q';
        setVisit(row, col, n, true);
        recursion(row + 1, n, board, res);
        board.get(row)[col] = '.';
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
