package com.wzx.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc
 *
 * @author wzx
 */
public class No13MatrixPath {

  /**
   * 深搜+回溯
   * <p>
   * time: O(n*(3^k))   n矩阵大小，k目标字符串长度，每次前进有3种可能，最大需要前进3^k次
   * space: O(max(n, k))    递归栈空间k 和 缓存visit数组n 的最大值
   */
  public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
    if (null == matrix) return false;
    Set<Integer> visit = new HashSet<>(matrix.length);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (backtrack(matrix, i, j, cols, rows, str, 0, visit)) return true;
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
   * @param cols        总列数
   * @param rows        总行数
   * @param target      目标字符串
   * @param targetBegin 剩余字符串的开始索引
   * @param visit       已访问位置
   * @return 是否可以得到目标字符串
   */
  public static boolean backtrack(char[] matrix, int row, int col, int cols, int rows, char[] target, int targetBegin, Set<Integer> visit) {
    if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
    int index = row * cols + col;
    if (visit.contains(index)) return false;
    if (target.length - 1 == targetBegin && target[targetBegin] == matrix[index]) return true;
    if (target[targetBegin] != matrix[index]) return false;

    visit.add(index);
    if (backtrack(matrix, row + 1, col, cols, rows, target, targetBegin + 1, visit)) return true;
    if (backtrack(matrix, row - 1, col, cols, rows, target, targetBegin + 1, visit)) return true;
    if (backtrack(matrix, row, col - 1, cols, rows, target, targetBegin + 1, visit)) return true;
    if (backtrack(matrix, row, col + 1, cols, rows, target, targetBegin + 1, visit)) return true;
    visit.remove(index);
    return false;
  }
}
