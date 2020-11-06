package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 *
 * @author wzx
 */
public class No43NumberOfOccurrencesOf1InAnInteger {

  /**
   * 找规律
   *
   * time: O(n)
   * space: O(1)
   */
  public int countDigitOne(int n) {
    int sum = 0;

    // 每位出现1的计数
    for (long longI = 1; longI <= n; longI *= 10) {
      // 最后一个longI <= n判断可能发生溢出
      int i = (int) longI;

      // a: 当前位及其之前的数字组合；b: 当前位之后的数字组合
      int a = n / i, b = n % i;
      // 当前位的值
      int bit = a % 10;

      if (bit == 0) {
        sum += a / 10 * i;
      } else if (bit == 1) {
        sum += a / 10 * i + (b + 1);
      } else {
        sum += (a / 10 + 1) * i;
      }
    }

    return sum;
  }
}
