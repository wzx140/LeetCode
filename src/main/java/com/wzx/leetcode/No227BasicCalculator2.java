package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/basic-calculator-ii/">https://leetcode.com/problems/basic-calculator-ii/</a>
 * @author wzx
 */
public class No227BasicCalculator2 {

  /**
   * 用栈缓存加减运算, 先计算乘除
   *
   * time: O(n)
   * space: O(n)
   */
  public int calculate(String s) {
    int curNum = 0;
    char curSignal = '+';
    // 用栈保存缓存信息
    Deque<Integer> stack = new LinkedList<>();
    // 暂存加减运算, 先计算乘除
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      // 数值
      if (Character.isDigit(ch)) curNum = 10 * curNum + (ch - '0');
      // 结尾或者运算符触发缓存数的计算
      if ((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == s.length() - 1) {
        if (curSignal == '*' || curSignal == '/') {
          // 乘除直接运算
          Integer lastNum = stack.pollFirst();
          stack.addFirst(cal(lastNum, curNum, curSignal));
        } else if (curSignal == '+' || curSignal == '-') {
          // 加减缓存起来
          stack.addFirst(cal(0, curNum, curSignal));
        }
        // 更新
        curNum = 0;
        curSignal = ch;
      }
    }

    return stack.stream().mapToInt(Integer::intValue).sum();
  }

  private int cal(int num1, int num2, char op) {
    int res = 0;
    switch (op) {
      case '+':
        res = num1 + num2;
        break;
      case '-':
        res = num1 - num2;
        break;
      case '*':
        res = num1 * num2;
        break;
      case '/':
        res = num1 / num2;
        break;
      default:
        break;
    }
    return res;
  }
}
