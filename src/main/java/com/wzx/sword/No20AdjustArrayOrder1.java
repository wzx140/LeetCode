package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593
 *
 * @author wzx
 */
public class No20AdjustArrayOrder1 {

  /**
   * 额外空间
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public static void reOrderArray1(int[] array) {
    if (array.length < 2) return;

    int[] res = new int[array.length];
    int oddIndex = 0;
    int evenIndex = (array.length + 1) / 2;

    for (int num : array) {
      if ((num & 1) == 0) {
        res[evenIndex++] = num;
      } else {
        res[oddIndex++] = num;
      }
    }

    System.arraycopy(res, 0, array, 0, array.length);
  }

  /**
   * 原地算法
   * <p>
   * time: O(n^2)
   * space: O(1)
   */
  public static void reOrderArray2(int[] array) {
    // 当前奇数应该存放位置
    int cur = 0;
    // 奇数位置
    int oddIndex = 0;

    while (oddIndex < array.length) {
      // 如果是奇数则插入cur之前
      if ((array[oddIndex] & 1) != 0) {
        int begin = oddIndex;
        int odd = array[oddIndex];
        while (begin > cur) {
          array[begin] = array[begin - 1];
          begin--;
        }
        array[cur++] = odd;
      }
      oddIndex++;
    }
  }
}
