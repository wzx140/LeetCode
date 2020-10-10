package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 *
 * @author wzx
 */
public class No34ADigitInASequenceOfNumbers {

  /**
   * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
   * 数字范围      位数     数字数量      数位数量
   * start~end   digit    9*start   9*start*digit
   *
   * time: O(logn)
   * space: O(logn)
   */
  public int findNthDigit(int n) {
    // 确定所在数字的位数
    long start = 1;
    int digit = 1;
    long cnt = 9;
    while (n > cnt) {
      n -= cnt;
      start *= 10;
      digit += 1;
      cnt = 9 * start * digit;
    }

    // 确定所在数字
    long num = start + (n - 1) / digit;

    // 确定所在数字中的数位
    return String.valueOf(num).charAt((n - 1) % digit) - '0';
  }
}
