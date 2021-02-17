package com.wzx.sword;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/">https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/</a>
 */
public class No12MatrixPath {
  // 方向
  int[][] dict = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  /**
   * 深搜+回溯
   * <p>
   * time: O(n*(3^k))   n矩阵大小，k目标字符串长度，每次前进有3种可能，最大需要前进3^k次
   * space: O(max(n, k))    递归栈空间k 和 缓存visit数组n 的最大值
   */
  public boolean exist(char[][] board, String word) {
    if (board.length == 0) return false;
    // 已访问格点
    boolean[][] visit = new boolean[board.length][board[0].length];
    char[] wordArray = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (recursion(board, i, j, wordArray, 0, visit)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 回溯
   *
   * @param board 矩阵
   * @param row   当前行号
   * @param col   当前列号
   * @param word  目标字符串
   * @param index 剩余字符串的开始索引
   * @param visit 已访问位置
   * @return 是否可以得到目标字符串
   */
  private boolean recursion(char[][] board,
                            int row,
                            int col,
                            char[] word,
                            int index,
                            boolean[][] visit) {
    if (index == word.length) return true;
    if (row >= board.length || col >= board[0].length || row < 0 || col < 0) return false;
    // 首个搜索元素在循环外部添加, 所以visit判断在循环外部
    if (visit[row][col]) return false;
    if (board[row][col] != word[index]) return false;
    // 回溯
    visit[row][col] = true;
    for (int i = 0; i < 4; i++) {
      int nextRow = row + dict[i][0];
      int nextCol = col + dict[i][1];
      if (recursion(board, nextRow, nextCol, word, index + 1, visit)) return true;
    }
    visit[row][col] = false;

    return false;
  }
}
