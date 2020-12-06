package com.wzx.leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

public class No224BasicCalculatorTest {

  @Test
  public void calculate() {
    No224BasicCalculator solution = new No224BasicCalculator();
    assertEquals(2, solution.calculate("1 + 1"));
    assertEquals(3, solution.calculate(" 2-1 + 2 "));
    assertEquals(-4, solution.calculate("1-(5)"));
    assertEquals(23, solution.calculate("(1+(4+5+2)-3)+(6+8)"));
  }
}