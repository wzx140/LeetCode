package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No1312MinimumInsertionStepsToMakeAStringPalindromeTest {

  private final String str1 = "zzazz";
  private final String str2 = "mbadm";
  private final String str3 = "leetcode";
  private final String str4 = "g";
  private final String str5 = "no";

  @Test
  public void minInsertions() {
    No1312MinimumInsertionStepsToMakeAStringPalindrome solution = new No1312MinimumInsertionStepsToMakeAStringPalindrome();
    assertEquals(0, solution.minInsertions1(str1));
    assertEquals(2, solution.minInsertions1(str2));
    assertEquals(5, solution.minInsertions1(str3));
    assertEquals(0, solution.minInsertions1(str4));
    assertEquals(1, solution.minInsertions1(str5));
  }
}