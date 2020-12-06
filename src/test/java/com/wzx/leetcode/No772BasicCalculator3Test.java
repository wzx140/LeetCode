package com.wzx.leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

public class No772BasicCalculator3Test {

  @Test
  public void calculate() {
    No772BasicCalculator3 solution = new No772BasicCalculator3();
    assertEquals(2, solution.calculate("1 + 1"));
    assertEquals(4, solution.calculate(" 6-4 / 2"));
    assertEquals(4, solution.calculate("2*(5+5*2)/3+(6/2+8)"));
  }
}