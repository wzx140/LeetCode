package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No714BestTimeToBuyAndSellStockWithTransactionFeeTest {

  private final int[] prices = {1, 3, 2, 8, 4, 9};

  @Test
  public void maxProfit1() {
    No714BestTimeToBuyAndSellStockWithTransactionFee solution = new No714BestTimeToBuyAndSellStockWithTransactionFee();
    assertEquals(8, solution.maxProfit1(prices, 2));
  }

  @Test
  public void testMaxProfit2() {
    No714BestTimeToBuyAndSellStockWithTransactionFee solution = new No714BestTimeToBuyAndSellStockWithTransactionFee();
    assertEquals(8, solution.maxProfit2(prices, 2));
  }
}