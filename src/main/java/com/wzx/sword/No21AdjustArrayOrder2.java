package com.wzx.sword;

/**
 * 与20题类似，但不要求保证相对位置关系
 *
 * @author wzx
 */
public class No21AdjustArrayOrder2 {

  /**
   * 双指针交换
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public static void reOrderArray1(int[] array) {
    int oddIndex = 0;
    int evenIndex = array.length - 1;

    while (oddIndex < evenIndex) {
      // 找到前半部分的偶数
      while (oddIndex < evenIndex && (array[oddIndex] & 1) != 0) oddIndex++;
      // 找到后半部分的奇数
      while (oddIndex < evenIndex && (array[evenIndex] & 1) != 1) evenIndex--;
      // 交换
      if (oddIndex < evenIndex) {
        int tmp = array[oddIndex];
        array[oddIndex] = array[evenIndex];
        array[evenIndex] = tmp;
      }
    }
  }
}
