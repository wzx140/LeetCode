package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No123BestTimeToBuyAndSellStock3Test {

  private final int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
  private final int[] prices2 = {1, 2, 3, 4, 5};
  private final int[] prices3 = {7, 6, 4, 3, 1};
  private final int[] prices4 = {1};

  @Test
  public void maxProfit1() {
    No123BestTimeToBuyAndSellStock3 solution = new No123BestTimeToBuyAndSellStock3();
    assertEquals(6, solution.maxProfit1(prices1));
    assertEquals(4, solution.maxProfit1(prices2));
    assertEquals(0, solution.maxProfit1(prices3));
    assertEquals(0, solution.maxProfit1(prices4));
  }

  @Test
  public void maxProfit2() {
    No123BestTimeToBuyAndSellStock3 solution = new No123BestTimeToBuyAndSellStock3();
    assertEquals(6, solution.maxProfit2(prices1));
    assertEquals(4, solution.maxProfit2(prices2));
    assertEquals(0, solution.maxProfit2(prices3));
    assertEquals(0, solution.maxProfit2(prices4));
  }
}