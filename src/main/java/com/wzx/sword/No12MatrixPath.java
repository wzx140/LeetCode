package com.wzx.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * @author wzx
 */
public class No12MatrixPath {

  /**
   * 深搜+回溯
   * <p>
   * time: O(n*(3^k))   n矩阵大小，k目标字符串长度，每次前进有3种可能，最大需要前进3^k次
   * space: O(max(n, k))    递归栈空间k 和 缓存visit数组n 的最大值
   */
  public boolean exist(char[][] board, String word) {
    if (null == board) return false;
    int rows = board.length;
    int cols = board[0].length;
    Set<Integer> visit = new HashSet<>(rows * cols);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (backtrack(board, i, j, word, 0, visit)) return true;
      }
    }

    return false;
  }

  /**
   * 回溯
   *
   * @param matrix      矩阵
   * @param row         当前行号
   * @param col         当前列号
   * @param word      目标字符串
   * @param targetBegin 剩余字符串的开始索引
   * @param visit       已访问位置
   * @return 是否可以得到目标字符串
   */
  public boolean backtrack(char[][] matrix, int row, int col, String word, int targetBegin, Set<Integer> visit) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return false;
    int index = row * matrix[0].length + col;
    if (visit.contains(index)) return false;
    if (word.length() - 1 == targetBegin && word.charAt(targetBegin) == matrix[row][col]) return true;
    if (word.charAt(targetBegin) != matrix[row][col]) return false;

    visit.add(index);
    if (backtrack(matrix, row + 1, col, word, targetBegin + 1, visit)) return true;
    if (backtrack(matrix, row - 1, col, word, targetBegin + 1, visit)) return true;
    if (backtrack(matrix, row, col - 1, word, targetBegin + 1, visit)) return true;
    if (backtrack(matrix, row, col + 1, word, targetBegin + 1, visit)) return true;
    visit.remove(index);
    return false;
  }
}
