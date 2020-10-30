package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No121BestTimeToBuyAndSellStockTest {

  private final int[] prices1 = {7, 1, 5, 3, 6, 4};
  private final int[] prices2 = {7, 6, 4, 3, 1};

  @Test
  public void maxProfit1() {
    No121BestTimeToBuyAndSellStock solution = new No121BestTimeToBuyAndSellStock();
    assertEquals(5, solution.maxProfit1(prices1));
    assertEquals(0, solution.maxProfit1(prices2));
  }

  @Test
  public void maxProfit2() {
    No121BestTimeToBuyAndSellStock solution = new No121BestTimeToBuyAndSellStock();
    assertEquals(5, solution.maxProfit2(prices1));
    assertEquals(0, solution.maxProfit2(prices2));
  }
}