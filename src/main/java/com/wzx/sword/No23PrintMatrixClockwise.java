package com.wzx.sword;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a
 *
 * @author wzx
 */
public class No23PrintMatrixClockwise {

  /**
   * time: O(mn)
   * space: O(mn)
   */
  public static ArrayList<Integer> printMatrix(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    ArrayList<Integer> output = new ArrayList<>(Collections.nCopies(row * col, 0));

    int layer = Math.min(col, row) / 2;
    int offset = 0;
    for (int i = 0; i < layer; i++) {
      offset = printRing(matrix, row, col, output, offset, i);
    }

    if (offset < col * row) {
      for (int j = layer; j < col - layer; j++) {
        for (int i = layer; i < row - layer; i++) {
          output.set(offset++, matrix[i][j]);
        }
      }
    }

    return output;
  }

  /**
   * 打印当前层
   *
   * @param matrix matrix
   * @param row    总行数
   * @param col    总列数
   * @param output 输出
   * @param offset output偏移量
   * @param layer  当前层
   * @return output中的偏移量
   */
  private static int printRing(int[][] matrix,
                               int row,
                               int col,
                               ArrayList<Integer> output,
                               int offset,
                               int layer) {

    for (int i = layer; i < col - layer - 1; i++) {
      output.set(offset++, matrix[layer][i]);
    }
    for (int i = layer; i < row - layer - 1; i++) {
      output.set(offset++, matrix[i][col - 1 - layer]);
    }
    for (int i = col - 1 - layer; i >= layer + 1; i--) {
      output.set(offset++, matrix[row - 1 - layer][i]);
    }
    for (int i = row - 1 - layer; i >= layer + 1; i--) {
      output.set(offset++, matrix[i][layer]);
    }

    return offset;
  }
}
