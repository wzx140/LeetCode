package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No51ReversedPairsInTheArrayTest {

  private final int[] nums = {7, 5, 6, 4};

  @Test
  public void reversePairs() {
    No51ReversedPairsInTheArray solution = new No51ReversedPairsInTheArray();
    assertEquals(5, solution.reversePairs(nums));
  }
}