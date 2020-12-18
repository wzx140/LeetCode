package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/surrounded-regions/
 *
 * @author wzx
 */
public class No130SurroundedRegions {

  /**
   * 从边缘深搜
   * <p>
   * time: O(mn)
   * space: O(mn)
   */
  public void solve1(char[][] board) {
    if (board.length == 0) return;
    // 标记四周的O连通区域
    for (int i = 0; i < board[0].length; i++) {
      dfs(board, 0, i);
    }
    for (int i = 0; i < board[0].length; i++) {
      dfs(board, board.length - 1, i);
    }
    for (int i = 0; i < board.length; i++) {
      dfs(board, i, 0);
    }
    for (int i = 0; i < board.length; i++) {
      dfs(board, i, board[0].length - 1);
    }

    // 将被包围的O翻转
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
      }
    }

    // 将标记变回O
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '#') board[i][j] = 'O';
      }
    }
  }

  /**
   * 标记O连通区域
   */
  private void dfs(char[][] board, int r, int c) {
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
      return;
    }

    if (board[r][c] == 'O') {
      board[r][c] = '#';
      dfs(board, r + 1, c);
      dfs(board, r, c + 1);
      dfs(board, r - 1, c);
      dfs(board, r, c - 1);
    }
  }

  private static class UF {
    private int[] parent = null;
    private int[] count = null;

    public UF(int size) {
      parent = new int[size];
      count = new int[size];
      for (int i = 0; i < size; i++) {
        parent[i] = i;
      }
    }

    /**
     * 寻找根结点
     */
    public int find(int x) {
      if (parent[x] == x) return x;
      // 路径压缩
      parent[x] = find(parent[x]);
      return parent[x];
    }

    /**
     * 连接两个树
     */
    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX == rootY) {
        return;
      }

      // 加权合并
      if (count[rootX] < count[rootY]) {
        int tmp = rootX;
        rootX = rootY;
        rootY = tmp;
      }
      parent[rootY] = rootX;
      count[rootX] += count[rootY];
    }

    public boolean isConnect(int x, int y) {
      return find(x) == find(y);
    }
  }

  /**
   * 并查集
   * <p>
   * time: O(mn)
   * space: O(mn)
   */
  public void solve2(char[][] board) {
    if (board.length == 0) return;
    // 铺平board, 并增加dummy结点, 其子结点表示不被包围的O区域
    UF uf = new UF(board.length * board[0].length + 1);
    // 将边缘区域的O连接到dummy
    int DUMMY = board.length * board[0].length;
    for (int i = 0; i < board[0].length; i++) {
      uf.union(DUMMY, i);
    }
    for (int i = 0; i < board[0].length; i++) {
      uf.union(DUMMY, (board.length - 1) * board[0].length + i);
    }
    for (int i = 0; i < board.length; i++) {
      uf.union(DUMMY, i * board[0].length);
    }
    for (int i = 0; i < board.length; i++) {
      uf.union(DUMMY, i * board[0].length + board[0].length - 1);
    }
    // 将中间的O与其四周的O连接
    for (int i = 1; i < board.length - 1; i++) {
      for (int j = 1; j < board[0].length - 1; j++) {
        if (board[i][j] == 'O') {
          if (board[i - 1][j] == 'O') uf.union(i * board[0].length + j, (i - 1) * board[0].length + j);
          if (board[i][j - 1] == 'O') uf.union(i * board[0].length + j, i * board[0].length + j - 1);
          if (board[i + 1][j] == 'O') uf.union(i * board[0].length + j, (i + 1) * board[0].length + j);
          if (board[i][j + 1] == 'O') uf.union(i * board[0].length + j, i * board[0].length + j + 1);
        }
      }
    }
    // 除了与DUMMY子结点外, 全部翻转为X
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O' && !uf.isConnect(DUMMY, i * board[0].length + j)) {
          board[i][j] = 'X';
        }
      }
    }
  }
}
