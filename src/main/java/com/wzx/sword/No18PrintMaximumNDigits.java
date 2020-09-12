package com.wzx.sword;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999
 * 大数问题，不能直接用迭代，因为数据的总量是巨大的
 *
 * @author wzx
 */
public class No18PrintMaximumNDigits {

  /**
   * 字符串表示数字，直接根据加法运算生成
   */
  public static void print1ToMaxOfNDigits1(int n) {
    char[] num = new char[n];
    Arrays.fill(num, '0');

    while (increment(num)) {
      boolean begin = false;
      for (char c : num) {
        // 不打印前导0
        if (!begin && c != '0') {
          begin = true;
          System.out.print(c);
        } else if (begin) {
          System.out.print(c);
        }
      }
      System.out.println();
    }
  }

  private static boolean increment(char[] num) {
    // 进位
    boolean takeOver = true;

    for (int i = num.length - 1; i >= 0 && takeOver; i--) {
      int digit = takeOver ? num[i] + 1 : num[i];
      if (digit > 57) {
        num[i] = '0';
        takeOver = true;
      } else {
        num[i] = (char) digit;
        takeOver = false;
      }
    }

    // 最高位进位代表溢出
    return !takeOver;
  }

  /**
   * 字符串表示数字，根据排列组合生成，递归
   */
  public static void print1ToMaxOfNDigits2(int n) {
    char[] num = new char[n];
    Arrays.fill(num, '0');

    recursion(num, 0);
  }

  private static void recursion(char[] num, int bit) {
    if (bit == num.length) {
      StringBuilder sb = new StringBuilder();
      for (char c : num) {
        // 不打印前导0
        if (sb.length() != 0 && c == '0') {
          sb.append(c);
        } else if (c != '0') {
          sb.append(c);
        }
      }
      if (sb.length() != 0) {
        sb.append('\n');
        System.out.print(sb.toString());
      }
      return;
    }

    for (int i = 0; i <= 9; i++) {
      num[bit] = (char) (i + '0');
      recursion(num, bit + 1);
    }
  }
}
