package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No516LongestPalindromicSubsequenceTest {

  @Test
  public void longestPalindromeSubseq() {
    No516LongestPalindromicSubsequence solution = new No516LongestPalindromicSubsequence();
    assertEquals(4, solution.longestPalindromeSubseq("bbbab"));
    assertEquals(2, solution.longestPalindromeSubseq("cbbd"));
  }
}