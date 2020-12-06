package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/basic-calculator/
 *
 * @author wzx
 */
public class No224BasicCalculator {

  private static class State {
    public int num = 0;
    public char signal = '+';
  }

  /**
   * 用栈暂时保持现场信息以优先计算括号
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int calculate(String s) {
    State curState = new State();
    int curNum = 0;
    // 遇到括号时，用栈保存现场信息
    Deque<State> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      // 统计数值
      if (Character.isDigit(ch)) curNum = 10 * curNum + (ch - '0');
        // 符号
      else if (ch == '+' || ch == '-') {
        curState.num = cal(curState.num, curNum, curState.signal);
        curState.signal = ch;
        // 重置
        curNum = 0;
      }
      // 进入括号
      else if (ch == '(') {
        stack.addFirst(curState);
        curState = new State();
      }
      // 退出括号
      else if (ch == ')') {
        State lastState = stack.pollFirst();
        // 括号内的计算值
        int bracketVal = cal(curState.num, curNum, curState.signal);
        // 更新上一个状态的计算值
        curState.num = cal(lastState.num, bracketVal, lastState.signal);
        // 重置
        curNum = 0;
        curState.signal = '+';
      }
    }
    return cal(curState.num, curNum, curState.signal);
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
      default:
        break;
    }
    return res;
  }

}
