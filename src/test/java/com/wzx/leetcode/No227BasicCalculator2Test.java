package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No227BasicCalculator2Test {

  @Test
  public void calculate() {
    No227BasicCalculator2 solution = new No227BasicCalculator2();
    assertEquals(7, solution.calculate("3+2*2"));
    assertEquals(1, solution.calculate(" 3/2 "));
    assertEquals(5, solution.calculate(" 3+5 / 2 "));
    assertEquals(42, solution.calculate("42"));
  }
}