package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No567PermutationInStringTest {

  private final String s11 = "ab";
  private final String s12 = "eidbaooo";

  private final String s21 = "ab";
  private final String s22 = "eidboaoo";

  @Test
  public void checkInclusion() {
    No567PermutationInString solution = new No567PermutationInString();
    assertTrue(solution.checkInclusion(s11, s12));
    assertFalse(solution.checkInclusion(s21, s22));
  }
}