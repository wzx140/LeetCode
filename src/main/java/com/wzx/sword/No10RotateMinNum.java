package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba
 *
 * @author wzx
 */
public class No10RotateMinNum {

  /**
   * 二分搜索
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public static int minNumberInRotateArray(int[] array) {
    if (null == array || 0 == array.length) return 0;

    int begin = 0;
    int end = array.length - 1;
    int middle = 0;

    // 找到旋转序列的开头
    while (begin < end) {
      middle = begin + (end - begin) / 2;
      if (array[middle] > array[end]) {
        // 3 4 [5] 1 (2)
        // 旋转序列开头在[middle+1, end]
        begin = middle + 1;
      } else if (array[middle] < array[begin]) {
        // (4) 5 [1] 2 3
        // 旋转序列开头在[begin, middle]
        end = middle;
      } else {
        // (1) 0 [1] 1 (1)
        // (1) 1 [1] 0 (1)
        begin = begin - 1;
      }
    }

    return array[begin];
  }
}
