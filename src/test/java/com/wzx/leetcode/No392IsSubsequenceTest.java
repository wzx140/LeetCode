package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No392IsSubsequenceTest {

  private final String s1 = "abc";
  private final String t1 = "ahbgdc";
  private final String s2 = "axc";
  private final String t2 = "ahbgdc";

  @Test
  public void isSubsequence1() {
    No392IsSubsequence solution = new No392IsSubsequence();
    assertTrue(solution.isSubsequence1(s1, t1));
    assertFalse(solution.isSubsequence1(s2, t2));
  }

  @Test
  public void isSubsequence2() {
    No392IsSubsequence solution = new No392IsSubsequence();
    assertTrue(solution.isSubsequence2(s1, t1));
    assertFalse(solution.isSubsequence2(s2, t2));
  }
}