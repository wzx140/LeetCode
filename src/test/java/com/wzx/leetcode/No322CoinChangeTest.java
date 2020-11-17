package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No322CoinChangeTest {

  private final int[] coins1 = {1, 2, 5};
  private final int[] coins2 = {2};
  private final int[] coins3 = {1};
  private final int[] coins4 = {186, 419, 83, 408};

  @Test
  public void coinChange1() {
    No322CoinChange solution = new No322CoinChange();
    assertEquals(3, solution.coinChange1(coins1, 11));
    assertEquals(-1, solution.coinChange1(coins2, 3));
    assertEquals(0, solution.coinChange1(coins3, 0));
    assertEquals(1, solution.coinChange1(coins3, 1));
    assertEquals(2, solution.coinChange1(coins3, 2));
    assertEquals(20, solution.coinChange1(coins4, 6249));
  }

  @Test
  public void coinChange2() {
    No322CoinChange solution = new No322CoinChange();
    assertEquals(3, solution.coinChange2(coins1, 11));
    assertEquals(-1, solution.coinChange2(coins2, 3));
    assertEquals(0, solution.coinChange2(coins3, 0));
    assertEquals(1, solution.coinChange2(coins3, 1));
    assertEquals(2, solution.coinChange2(coins3, 2));
    assertEquals(20, solution.coinChange2(coins4, 6249));
  }
}