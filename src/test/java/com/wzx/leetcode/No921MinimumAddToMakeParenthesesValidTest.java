package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No921MinimumAddToMakeParenthesesValidTest {

  @Test
  public void minAddToMakeValid() {
    No921MinimumAddToMakeParenthesesValid solution = new No921MinimumAddToMakeParenthesesValid();
    assertEquals(1, solution.minAddToMakeValid("())"));
    assertEquals(3, solution.minAddToMakeValid("((("));
    assertEquals(0, solution.minAddToMakeValid("()"));
    assertEquals(4, solution.minAddToMakeValid("()))(("));
  }
}