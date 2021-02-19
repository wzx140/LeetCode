package com.wzx.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">https://leetcode.com/problems/different-ways-to-add-parentheses/</a>
 * @author wzx
 */
public class No241DifferentWaysToAddParentheses {

  /**
   * 分治
   * <p>
   * time: 卡特兰数
   * space: O(n)
   */
  public List<Integer> diffWaysToCompute(String input) {
    Map<Integer, List<Integer>> memo = new HashMap<>();
    return helper(input.toCharArray(), 0, input.length() - 1);
  }

  private List<Integer> helper(char[] input, int start, int end) {
    List<Integer> res = new LinkedList<>();
    // 分, 给当前表达式[start, end]加一层括号
    for (int i = start; i <= end; i++) {
      if (input[i] == '+' || input[i] == '-' || input[i] == '*') {
        // 以运算符为分割点, 两侧分别加括号
        List<Integer> left = helper(input, start, i - 1);
        List<Integer> right = helper(input, i + 1, end);
        // 合并, 左右两侧
        res.addAll(merge(left, right, input[i]));
      }
    }
    // 边界条件
    if (res.isEmpty()) {
      // 没有运算符，说明只有一个数字
      res.add(Integer.parseInt(new String(input, start, end - start + 1)));
    }

    return res;
  }

  /**
   * 将左右两侧所有可能值的笛卡尔积，根据运算符计算出归并后可能的值
   */
  private List<Integer> merge(List<Integer> left, List<Integer> right, char operator) {
    List<Integer> res = new LinkedList<>();
    for (Integer a : left) {
      for (Integer b : right) {
        res.add(cal(a, b, operator));
      }
    }
    return res;
  }

  private int cal(int a, int b, char operator) {
    if (operator == '+') {
      return a + b;
    } else if (operator == '-') {
      return a - b;
    } else {
      return a * b;
    }
  }
}
