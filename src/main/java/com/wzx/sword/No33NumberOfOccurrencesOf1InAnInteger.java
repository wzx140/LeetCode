package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6
 *
 * @author wzx
 */
public class No33NumberOfOccurrencesOf1InAnInteger {

  /**
   * 找规律
   *
   * time: O(n)
   * space: O(1)
   */
  public int NumberOf1Between1AndN_Solution(int n) {
    int sum = 0;

    // 每位出现1的计数
    for (int i = 1; i <= n; i *= 10) {
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
