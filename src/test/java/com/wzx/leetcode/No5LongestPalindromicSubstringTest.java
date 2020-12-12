package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class No5LongestPalindromicSubstringTest {

  private final String s1 = "babad";
  private final List<String> r1 = Arrays.asList("bab", "aba");
  private final String s2 = "cbbd";
  private final String r2 = "bb";
  private final String s3 = "a";
  private final String r3 = "a";
  private final String s4 = "ac";
  private final String r4 = "a";

  @Test
  public void longestPalindrome1() {
    No5LongestPalindromicSubstring solution = new No5LongestPalindromicSubstring();
    assertTrue(r1.contains(solution.longestPalindrome1(s1)));
    assertEquals(r2, solution.longestPalindrome1(s2));
    assertEquals(r3, solution.longestPalindrome1(s3));
    assertEquals(r4, solution.longestPalindrome1(s4));
  }

  @Test
  public void longestPalindrome2() {
    No5LongestPalindromicSubstring solution = new No5LongestPalindromicSubstring();
    assertTrue(r1.contains(solution.longestPalindrome2(s1)));
    assertEquals(r2, solution.longestPalindrome2(s2));
    assertEquals(r3, solution.longestPalindrome2(s3));
    assertEquals(r4, solution.longestPalindrome2(s4));
  }
}