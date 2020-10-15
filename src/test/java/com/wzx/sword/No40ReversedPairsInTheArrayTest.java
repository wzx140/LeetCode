package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No40ReversedPairsInTheArrayTest {

  private final int[] nums = {7, 5, 6, 4};

  @Test
  public void reversePairs() {
    No40ReversedPairsInTheArray solution = new No40ReversedPairsInTheArray();
    assertEquals(5, solution.reversePairs(nums));
  }
}