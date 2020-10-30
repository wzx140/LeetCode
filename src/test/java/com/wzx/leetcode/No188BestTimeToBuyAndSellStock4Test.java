package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No188BestTimeToBuyAndSellStock4Test {

  private final int[] prices1 = {2, 4, 1};
  private final int[] prices2 = {3, 2, 6, 5, 0, 3};

  @Test
  public void maxProfit1() {
    No188BestTimeToBuyAndSellStock4 solution = new No188BestTimeToBuyAndSellStock4();
    assertEquals(2, solution.maxProfit1(2, prices1));
    assertEquals(7, solution.maxProfit1(2, prices2));
  }

  @Test
  public void maxProfit2() {
    No188BestTimeToBuyAndSellStock4 solution = new No188BestTimeToBuyAndSellStock4();
    assertEquals(2, solution.maxProfit2(2, prices1));
    assertEquals(7, solution.maxProfit2(2, prices2));
  }
}