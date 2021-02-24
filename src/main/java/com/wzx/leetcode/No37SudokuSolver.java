package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/sudoku-solver/">https://leetcode.com/problems/sudoku-solver/</a>
 */
public class No37SudokuSolver {

  public void solveSudoku(char[][] board) {
    recursion(board, 0, 0);
  }

  private boolean recursion(char[][] board, int r, int c) {
    // 找到解
    if (r == 9) return true;
    // 跳到下一行求解
    if (c == 9) return recursion(board, r + 1, 0);
    if (board[r][c] != '.') return recursion(board, r, c + 1);

    for (char ch = '1'; ch <= '9'; ch++) {
      if (valid(board, r, c, ch)) {
        board[r][c] = ch;
        if (recursion(board, r, c + 1)) return true;
        board[r][c] = '.';
      }
    }
    return false;
  }

  private boolean valid(char[][] board, int r, int c, char ch) {
    // 行是否重复
    for (int i = 0; i < 9; i++) {
      if (board[r][i] == ch) return false;
    }
    // 列是否重复
    for (int i = 0; i < 9; i++) {
      if (board[i][c] == ch) return false;
    }
    // 小方块是否重复
    int rStart = r / 3 * 3;
    int cStart = c / 3 * 3;
    for (int i = rStart; i < rStart + 3; i++) {
      for (int j = cStart; j < cStart + 3; j++) {
        if (board[i][j] == ch) return false;
      }
    }
    return true;
  }
}
