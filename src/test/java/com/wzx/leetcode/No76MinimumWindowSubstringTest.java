package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No76MinimumWindowSubstringTest {

  @Test
  public void minWindow() {
    No76MinimumWindowSubstring solution = new No76MinimumWindowSubstring();
    assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
    assertEquals("a", solution.minWindow("a", "a"));
  }
}