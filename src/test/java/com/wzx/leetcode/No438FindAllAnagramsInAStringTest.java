package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class No438FindAllAnagramsInAStringTest {

  private final String s1 = "cbaebabacd";
  private final String p1 = "abc";
  private final List<Integer> res1 = Arrays.asList(0, 6);
  private final String s2 = "abab";
  private final String p2 = "ab";
  private final List<Integer> res2 = Arrays.asList(0, 1, 2);
  private final String s3 = "baa";
  private final String p3 = "aa";
  private final List<Integer> res3 = Arrays.asList(1);
  private final String s4 = "acdcaeccde";
  private final String p4 = "c";
  private final List<Integer> res4 = Arrays.asList(1, 3, 6, 7);


  @Test
  public void findAnagrams() {
    No438FindAllAnagramsInAString solution = new No438FindAllAnagramsInAString();
    assertEquals(res1, solution.findAnagrams(s1, p1));
    assertEquals(res2, solution.findAnagrams(s2, p2));
    assertEquals(res3, solution.findAnagrams(s3, p3));
    assertEquals(res4, solution.findAnagrams(s4, p4));
  }
}