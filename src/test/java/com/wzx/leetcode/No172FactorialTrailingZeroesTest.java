package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No172FactorialTrailingZeroesTest {

  @Test
  public void trailingZeroes() {
    No172FactorialTrailingZeroes solution = new No172FactorialTrailingZeroes();
    assertEquals(0, solution.trailingZeroes(3));
    assertEquals(1, solution.trailingZeroes(5));
    assertEquals(0, solution.trailingZeroes(0));
  }
}