package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No263UglyNumberTest {

  @Test
  public void isUgly() {
    No263UglyNumber solution = new No263UglyNumber();
    assertTrue(solution.isUgly(6));
    assertTrue(solution.isUgly(8));
    assertFalse(solution.isUgly(14));
  }
}