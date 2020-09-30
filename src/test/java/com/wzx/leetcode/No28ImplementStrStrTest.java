package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No28ImplementStrStrTest {

  private final String haystack1 = "hello";
  private final String needle1 = "ll";
  private final String haystack2 = "aaaaa";
  private final String needle2 = "bba";
  private final String haystack3 = "";
  private final String needle3 = "";

  @Test
  public void strStr1() {
    No28ImplementStrStr solution = new No28ImplementStrStr();
    assertEquals(2, solution.strStr1(haystack1, needle1));
    assertEquals(-1, solution.strStr1(haystack2, needle2));
    assertEquals(0, solution.strStr1(haystack3, needle3));
  }

  @Test
  public void strStr2() {
    No28ImplementStrStr solution = new No28ImplementStrStr();
    assertEquals(2, solution.strStr2(haystack1, needle1));
    assertEquals(-1, solution.strStr2(haystack2, needle2));
    assertEquals(0, solution.strStr2(haystack3, needle3));
  }

  @Test
  public void strStr3() {
    No28ImplementStrStr solution = new No28ImplementStrStr();
    assertEquals(2, solution.strStr2(haystack1, needle1));
    assertEquals(-1, solution.strStr2(haystack2, needle2));
    assertEquals(0, solution.strStr2(haystack3, needle3));
  }

  @Test
  public void strStr4() {
    No28ImplementStrStr solution = new No28ImplementStrStr();
    assertEquals(2, solution.strStr2(haystack1, needle1));
    assertEquals(-1, solution.strStr2(haystack2, needle2));
    assertEquals(0, solution.strStr2(haystack3, needle3));
  }
}