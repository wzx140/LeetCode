package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No61StraightInPlayingCardsTest {

  private final int[] cards1 = {1, 2, 3, 4, 5};
  private final int[] cards2 = {0, 0, 1, 2, 5};
  private final int[] cards3 = {0, 0, 2, 2, 5};

  @Test
  public void isStraight1() {
    No61StraightInPlayingCards solution = new No61StraightInPlayingCards();
    assertTrue(solution.isStraight1(cards1));
    assertTrue(solution.isStraight1(cards2));
    assertFalse(solution.isStraight1(cards3));
  }

  @Test
  public void isStraight2() {
    No61StraightInPlayingCards solution = new No61StraightInPlayingCards();
    assertTrue(solution.isStraight2(cards1));
    assertTrue(solution.isStraight2(cards2));
    assertFalse(solution.isStraight2(cards3));
  }
}