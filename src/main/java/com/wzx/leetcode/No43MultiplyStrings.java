package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/multiply-strings/
 *
 * @author wzx
 */
public class No43MultiplyStrings {

  /**
   * 迭代
   *
   * time: O(mn)
   * space: O(mn)
   */
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) return "0";

    int m = num1.length(), n = num2.length();
    int[] res = new int[m + n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        // i+j 为 num1[i]*num2[j] 摆放的位置
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        // 与res上对应位置相加
        int sum = res[i + j + 1] + mul;
        res[i + j + 1] = sum % 10;
        // 处理进位
        res[i + j] += sum / 10;
      }
    }

    // 去除前导0
    boolean leadingZero = true;
    StringBuilder sb = new StringBuilder();
    for (int num : res) {
      if (leadingZero && num != 0) leadingZero = false;
      if (!leadingZero) sb.append(num);
    }
    return sb.toString();
  }
}
