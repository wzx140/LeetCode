package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No309BestTimeToBuyAndSellStockWithCooldownTest {

  private final int[] prices = {1, 2, 3, 0, 2};

  @Test
  public void maxProfit1() {
    No309BestTimeToBuyAndSellStockWithCooldown solution = new No309BestTimeToBuyAndSellStockWithCooldown();
    assertEquals(3, solution.maxProfit1(prices));
  }

  @Test
  public void maxProfit2() {
    No309BestTimeToBuyAndSellStockWithCooldown solution = new No309BestTimeToBuyAndSellStockWithCooldown();
    assertEquals(3, solution.maxProfit2(prices));
  }
}