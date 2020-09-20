package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No20ValidParenthesesTest {

  @Test
  public void isValid() {
    No20ValidParentheses solution = new No20ValidParentheses();
    assertTrue(solution.isValid("()"));
    assertTrue(solution.isValid("()[]{}"));
    assertFalse(solution.isValid("(]"));
    assertFalse(solution.isValid("([)]"));
    assertTrue(solution.isValid("{[]}"));
  }
}