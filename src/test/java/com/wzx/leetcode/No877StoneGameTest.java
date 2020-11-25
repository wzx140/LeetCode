package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class No877StoneGameTest {

  private final int[] piles = {5, 3, 4, 5};

  @Test
  public void stoneGame() {
    No877StoneGame solution = new No877StoneGame();
    assertTrue(solution.stoneGame(piles));
  }
}