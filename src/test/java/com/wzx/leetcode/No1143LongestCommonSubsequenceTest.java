package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No1143LongestCommonSubsequenceTest {

  @Test
  public void longestCommonSubsequence() {
    No1143LongestCommonSubsequence solution = new No1143LongestCommonSubsequence();
    assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"));
    assertEquals(3, solution.longestCommonSubsequence("abc", "abc"));
    assertEquals(0, solution.longestCommonSubsequence("abc", "def"));
  }
}