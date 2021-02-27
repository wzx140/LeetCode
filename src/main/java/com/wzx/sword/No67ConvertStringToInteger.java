package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/">https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/</a>
 * @author wzx
 */
public class No67ConvertStringToInteger {

  /**
   * 字符串2数字
   *
   * time: O(n)
   * space: O(1)
   */
  public int strToInt(String str) {
    if (str.isEmpty()) return 0;

    // 丢弃前导空格
    int index = 0;
    while (index < str.length() && str.charAt(index) == ' ') index++;
    if (index == str.length()) return 0;

    // 符号位
    boolean symbol = false;
    char ch = str.charAt(index);
    if (ch == '-') {
      symbol = true;
      index++;
    } else if (ch == '+') {
      index++;
    } else if (!Character.isDigit(ch)) {
      // 非有效字符, 不能转换
      return 0;
    }

    // 数字位
    int num = 0;
    while (index < str.length() && Character.isDigit(ch = str.charAt(index))) {
      int digit = ch - 48;
      // max: 2147483647
      // min: -2147483648
      if (!symbol) {
        if (num > 214748364 || (num == 214748364 && digit >= 7)) return Integer.MAX_VALUE;
        num *= 10;
        num += digit;
      } else {
        if (num < -214748364 || (num == -214748364 && digit >= 8)) return Integer.MIN_VALUE;
        num *= 10;
        num -= digit;
      }
      index++;
    }

    return num;
  }
}
