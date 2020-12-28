package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No793PreimageSizeOfFactorialZeroesFunctionTest {

  @Test
  public void preimageSizeFZF() {
    No793PreimageSizeOfFactorialZeroesFunction solution = new No793PreimageSizeOfFactorialZeroesFunction();
    assertEquals(5, solution.preimageSizeFZF(0));
    assertEquals(0, solution.preimageSizeFZF(5));
  }
}