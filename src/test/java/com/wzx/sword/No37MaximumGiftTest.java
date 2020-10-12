package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No37MaximumGiftTest {

  private final int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
  private final int[][] grid2 = {{1, 2, 5}, {3, 2, 1}};

  @Test
  public void maxValue1() {
    No37MaximumGift solution = new No37MaximumGift();
    assertEquals(12, solution.maxValue1(grid1));
    assertEquals(9, solution.maxValue1(grid2));
  }

  @Test
  public void maxValue2() {
    No37MaximumGift solution = new No37MaximumGift();
    assertEquals(12, solution.maxValue2(grid1));
    assertEquals(9, solution.maxValue2(grid2));
  }
}