package com.wzx.leetcode;

import java.util.*;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">https://leetcode.com/problems/valid-parentheses/</a>
 */
public class No20ValidParentheses {

  /**
   * 栈
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public boolean isValid(String s) {
    Deque<Character> stack = new LinkedList<>();
    for (char ch : s.toCharArray()) {
      // 右括号
      if (ch == ')' || ch == ']' || ch == '}') {
        // 当前右括号是否和最近左括号成对
        if (stack.isEmpty() || stack.pollFirst() != ch) return false;
      }
      // 左括号
      else {
        // 向栈中添加对应右括号
        if (ch == '(') {
          stack.addFirst(')');
        } else if (ch == '[') {
          stack.addFirst(']');
        } else {
          stack.addFirst('}');
        }
      }
    }
    return stack.isEmpty();
  }
}
