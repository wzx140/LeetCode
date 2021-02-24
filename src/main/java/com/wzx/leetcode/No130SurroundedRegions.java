package com.wzx.leetcode;

import com.wzx.entity.UF;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/surrounded-regions/">https://leetcode.com/problems/surrounded-regions/</a>
 */
public class No130SurroundedRegions {
  // 搜索的四个方向
  private final int[][] dir = {
          {0, 1},
          {1, 0},
          {0, -1},
          {-1, 0}
  };

  /**
   * 从边缘深搜标记非被X包围的O
   * <p>
   * time: O(mn)
   * space: O(mn)
   */
  public void solve1(char[][] board) {
    int n = board.length, m = board[0].length;
    // 从四周搜索O连通区域, 并标记
    for (int i = 0; i < n; i++) {
      recursion(board, i, 0);
      recursion(board, i, m - 1);
    }
    for (int i = 0; i < m; i++) {
      recursion(board, 0, i);
      recursion(board, n - 1, i);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'E') {
          // 将标记变回O
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          // 将被X包围的O翻转
          board[i][j] = 'X';
        }
      }
    }
  }

  /**
   * 标记O联通区域
   */
  private void recursion(char[][] board, int row, int col) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
    if (board[row][col] == 'X') return;
    if (board[row][col] == 'E') return;
    if (board[row][col] == 'O') board[row][col] = 'E';

    for (int i = 0; i < 4; i++) {
      recursion(board, row + dir[i][0], col + dir[i][1]);
    }
  }

  /**
   * 并查集
   * <p>
   * time: O(mn)
   * space: O(mn)
   */
  public void solve2(char[][] board) {
    int m = board.length, n = board[0].length;
    // 利用并查集保存O区域与外界的连通关系
    UF uf = new UF(m * n + 1);
    // 规定m*n为外界, 与m*n相连的O区域与外界连通
    int OUTSIDE = m * n;

    // 边缘的O和外界连通
    for (int r = 0; r < m; r++) {
      if (board[r][0] == 'O') uf.union(r * n, OUTSIDE);
      if (board[r][n - 1] == 'O') uf.union(r * n + n - 1, OUTSIDE);
    }
    for (int c = 0; c < n; c++) {
      if (board[0][c] == 'O') uf.union(c, OUTSIDE);
      if (board[m - 1][c] == 'O') uf.union((m - 1) * n + c, OUTSIDE);
    }
    // 内部的O与其四周的O连通
    for (int r = 1; r < m - 1; r++) {
      for (int c = 1; c < n - 1; c++) {
        if (board[r][c] == 'O') {
          for (int i = 0; i < 4; i++) {
            if (board[r + dir[i][0]][c + dir[i][1]] == 'O') {
              uf.union(r * n + c, (r + dir[i][0]) * n + c + dir[i][1]);
            }
          }
        }
      }
    }
    // 所有不与OUTSIDE连通的O翻转为X
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (board[r][c] == 'O' && !uf.isConnect(OUTSIDE, r * n + c)) {
          board[r][c] = 'X';
        }
      }
    }
  }
}
