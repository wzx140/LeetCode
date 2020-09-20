package com.wzx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author wzx
 */
public class No20ValidParentheses {

  /**
   * 栈
   *
   * time: O(n)
   * space: O(n)
   */
  public boolean isValid(String s) {
    Map<Character, Character> bracket = new HashMap<>();
    bracket.put('(', ')');
    bracket.put('[', ']');
    bracket.put('{', '}');

    Deque<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (bracket.containsKey(ch)) {
        stack.push(ch);
      } else if (!stack.isEmpty() && bracket.get(stack.peek()) == ch) {
        stack.pop();
      } else {
        return false;
      }
    }

    return stack.isEmpty();
  }
}
