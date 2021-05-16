package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No69SqrtXTest {

  @Test
  public void mySqrt() {
    No69SqrtX solution = new No69SqrtX();
    assertEquals(2, solution.mySqrt(4));
    assertEquals(2, solution.mySqrt(8));
  }
}