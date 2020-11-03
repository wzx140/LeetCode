package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author wzx
 */
public class No11RotateMinNum {

  /**
   * 二分搜索
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public int minArray(int[] numbers) {
    if (null == numbers || 0 == numbers.length) return 0;

    int begin = 0;
    int end = numbers.length - 1;
    int middle = 0;

    // 旋转序列将序列分成两个有序序列
    while (begin < end) {
      middle = begin + (end - begin) / 2;
      if (numbers[middle] > numbers[end]) {
        // 3 4 [5] 1 (2)
        // [begin, middle]属于后半段有序序列
        // 最小值一定在[middle+1, end]中
        begin = middle + 1;
      } else if (numbers[middle] < numbers[end]) {
        // 4 5 [1] 2 (3)
        // [middle, end]属于前半段有序序列
        // 最小值一定在[begin, middle]中
        end = middle;
      } else {
        // (1) 0 [1] 1 (1)
        // (1) 1 [1] 0 (1)
        // 不能确定最小值在middle的左侧还是右侧
        // end可以被忽略, 即使是最小值也可以被middle替代
        end = end - 1;
      }
    }

    return numbers[begin];
  }
}
