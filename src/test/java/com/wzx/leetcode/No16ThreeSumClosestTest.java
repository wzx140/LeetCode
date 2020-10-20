package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No16ThreeSumClosestTest {

  private final int[] nums = {-1, 2, 1, -4};

  @Test
  public void threeSumClosest() {
    No16ThreeSumClosest solution = new No16ThreeSumClosest();
    assertEquals(2, solution.threeSumClosest(nums, 1));
  }
}