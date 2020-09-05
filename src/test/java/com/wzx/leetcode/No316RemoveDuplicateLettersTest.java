package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No316RemoveDuplicateLettersTest {

  private final String str1 = "bcabc";
  private final String str2 = "cbacdcbc";

  @Test
  public void removeDuplicateLetters1() {
    No316RemoveDuplicateLetters solution = new No316RemoveDuplicateLetters();
    assertEquals("abc",solution.removeDuplicateLetters1(str1));
    assertEquals("acdb",solution.removeDuplicateLetters1(str2));
  }
}