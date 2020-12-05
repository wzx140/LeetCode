package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No518CoinChange2Test {

  private final int[] coins1 = {1, 2, 5};
  private final int[] coins2 = {2};
  private final int[] coins3 = {10};

  @Test
  public void change() {
    No518CoinChange2 solution = new No518CoinChange2();
    assertEquals(4, solution.change(5, coins1));
    assertEquals(0, solution.change(3, coins2));
    assertEquals(1, solution.change(10, coins3));
  }
}