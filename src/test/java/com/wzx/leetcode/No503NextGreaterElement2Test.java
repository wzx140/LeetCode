package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No503NextGreaterElement2Test {

  private final int[] nums = {1, 2, 1};
  private final int[] res = {2, -1, 2};

  @Test
  public void nextGreaterElements() {
    No503NextGreaterElement2 solution = new No503NextGreaterElement2();
    assertArrayEquals(res, solution.nextGreaterElements(nums));
  }
}