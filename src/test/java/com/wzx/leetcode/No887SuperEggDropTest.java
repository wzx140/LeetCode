package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No887SuperEggDropTest {

  @Test
  public void superEggDrop1() {
    No887SuperEggDrop solution = new No887SuperEggDrop();
    assertEquals(2, solution.superEggDrop1(1, 2));
    assertEquals(3, solution.superEggDrop1(2, 6));
    assertEquals(4, solution.superEggDrop1(3, 14));
  }

  @Test
  public void superEggDro2() {
    No887SuperEggDrop solution = new No887SuperEggDrop();
    assertEquals(2, solution.superEggDrop2(1, 2));
    assertEquals(3, solution.superEggDrop2(2, 6));
    assertEquals(4, solution.superEggDrop2(3, 14));
  }
}