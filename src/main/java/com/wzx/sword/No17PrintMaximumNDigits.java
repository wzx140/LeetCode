package com.wzx.sword;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/">https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/</a>
 */
public class No17PrintMaximumNDigits {

  /**
   * 字符串表示数字，根据排列组合生成，深搜
   * <p>
   * time: O(10^n)
   * space: O(10^n)
   */
  public int[] printNumbers1(int n) {
    char[] num = new char[n];
    Arrays.fill(num, '0');

    List<Integer> res = new LinkedList<>();
    recursion(num, 0, res);
    res.remove(0);

    return res.stream().mapToInt(Integer::intValue).toArray();
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
