package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.lintcode.com/problem/basic-calculator-iii/description
 *
 * @author wzx
 */
public class No772BasicCalculator3 {

  private static class State {
    // 用栈来缓存加法运算结果, 先进行乘除
    Deque<Integer> stack = new LinkedList<>();
    char op = '+';
  }

  /**
   * 综合224处理括号的方式与227处理乘除的方式
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int calculate(String s) {
    State state = new State();
    int curNum = 0;
    char curOp = '+';

    // 用栈来缓存现场信息, 先进行括号内运算
    Deque<State> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      // 数值
      if (Character.isDigit(ch)) curNum = curNum * 10 + (ch - '0');
      // 符号或者最后一位触发更新
      if ((!Character.isDigit(ch) && !Character.isWhitespace(ch)) || i == s.length() - 1 || ch == ')') {
        if (curOp == '*' || curOp == '/') {
          // 乘除直接运算
          int lastNum = state.stack.pollFirst();
          state.stack.addFirst(cal(lastNum, curNum, curOp));
        } else if (curOp == '+' || curOp == '-') {
          // 加减缓存起来
          state.stack.addFirst(cal(0, curNum, curOp));
        }
        // 更新
        curOp = ch;
        curNum = 0;
      }
      // 缓存并重置现场
      if (ch == '(') {
        state.op = curOp;
        stack.addFirst(state);
        state = new State();
        curOp = '+';
      }
      if (ch == ')') {
        // 计算括号内的值
        curNum = state.stack.stream().mapToInt(Integer::intValue).sum();
        // 取出缓存的现场中
        state = stack.pollFirst();
        curOp = state.op;
      }
    }
    return state.stack.stream().mapToInt(Integer::intValue).sum();
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
