package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No122BestTimeToBuyAndSellStock2Test {

  private final int[] prices1 = {7, 1, 5, 3, 6, 4};
  private final int[] prices2 = {1, 2, 3, 4, 5};
  private final int[] prices3 = {7, 6, 4, 3, 1};

  @Test
  public void maxProfit1() {
    No122BestTimeToBuyAndSellStock2 solution = new No122BestTimeToBuyAndSellStock2();
    assertEquals(7, solution.maxProfit1(prices1));
    assertEquals(4, solution.maxProfit1(prices2));
    assertEquals(0, solution.maxProfit1(prices3));
  }

  @Test
  public void maxProfit2() {
    No122BestTimeToBuyAndSellStock2 solution = new No122BestTimeToBuyAndSellStock2();
    assertEquals(7, solution.maxProfit2(prices1));
    assertEquals(4, solution.maxProfit2(prices2));
    assertEquals(0, solution.maxProfit2(prices3));
  }
}