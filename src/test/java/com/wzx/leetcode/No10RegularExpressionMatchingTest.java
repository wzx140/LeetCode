package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No10RegularExpressionMatchingTest {

  private final String s1 = "aa";
  private final String p1 = "a";
  private final String s2 = "aa";
  private final String p2 = "a*";
  private final String s3 = "ab";
  private final String p3 = ".*";
  private final String s4 = "aab";
  private final String p4 = "c*a*b";
  private final String s5 = "mississippi";
  private final String p5 = "mis*is*p*.";
  private final String s6 = "ab";
  private final String p6 = ".*c";

  @Test
  public void isMatch1() {
    No10RegularExpressionMatching solution = new No10RegularExpressionMatching();
    assertFalse(solution.isMatch1(s1, p1));
    assertTrue(solution.isMatch1(s2, p2));
    assertTrue(solution.isMatch1(s3, p3));
    assertTrue(solution.isMatch1(s4, p4));
    assertFalse(solution.isMatch1(s5, p5));
    assertFalse(solution.isMatch1(s6, p6));
  }

  @Test
  public void isMatch2() {
    No10RegularExpressionMatching solution = new No10RegularExpressionMatching();
    assertFalse(solution.isMatch2(s1, p1));
    assertTrue(solution.isMatch2(s2, p2));
    assertTrue(solution.isMatch2(s3, p3));
    assertTrue(solution.isMatch2(s4, p4));
    assertFalse(solution.isMatch2(s5, p5));
    assertFalse(solution.isMatch2(s6, p6));
  }
}