package com.wzx.sword;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * @author wzx
 */
public class No17PrintMaximumNDigits {

  /**
   * 字符串表示数字，直接根据加法运算生成
   * <p>
   * time: O(10^n*n)
   * space: O(10^n)
   */
  public int[] printNumbers1(int n) {
    char[] num = new char[n];
    Arrays.fill(num, '0');
    int[] res = new int[(int) Math.pow(10, n) - 1];

    int index = 0;
    while (increment(num)) {
      res[index++] = Integer.parseInt(String.valueOf(num));
    }

    return res;
  }

  private boolean increment(char[] num) {
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
   * 字符串表示数字，根据排列组合生成，深搜
   *
   * time: O(10^n)
   * space: O(10^n)
   */
  public int[] printNumbers2(int n) {
    char[] num = new char[n];
    Arrays.fill(num, '0');

    List<Integer> res = new LinkedList<>();
    recursion(num, 0, res);
    res.remove(0);

    return res.stream().mapToInt(i -> i).toArray();
  }

  private void recursion(char[] num, int bit, List<Integer> res) {
    if (bit == num.length) {
      res.add(Integer.parseInt(String.valueOf(num)));
      return;
    }

    for (int i = 0; i <= 9; i++) {
      num[bit] = (char) (i + '0');
      recursion(num, bit + 1, res);
    }
  }
}
