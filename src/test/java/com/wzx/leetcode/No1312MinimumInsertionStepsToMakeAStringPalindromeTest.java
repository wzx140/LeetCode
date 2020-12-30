package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No1312MinimumInsertionStepsToMakeAStringPalindromeTest {

  @Test
  public void minInsertions() {
    No1312MinimumInsertionStepsToMakeAStringPalindrome solution = new No1312MinimumInsertionStepsToMakeAStringPalindrome();
    assertEquals(0, solution.minInsertions("zzazz"));
    assertEquals(2, solution.minInsertions("mbadm"));
    assertEquals(5, solution.minInsertions("leetcode"));
    assertEquals(0, solution.minInsertions("g"));
    assertEquals(1, solution.minInsertions("no"));
  }
}