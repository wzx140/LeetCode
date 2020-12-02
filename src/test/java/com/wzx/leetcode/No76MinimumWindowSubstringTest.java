package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No76MinimumWindowSubstringTest {

  private final String s1 = "ADOBECODEBANC";
  private final String t1 = "ABC";
  private final String res1 = "BANC";
  private final String s2 = "a";
  private final String t2 = "a";
  private final String res2 = "a";

  @Test
  public void minWindow() {
    No76MinimumWindowSubstring solution = new No76MinimumWindowSubstring();
    assertEquals(res1, solution.minWindow(s1, t1));
    assertEquals(res2, solution.minWindow(s2, t2));
  }
}