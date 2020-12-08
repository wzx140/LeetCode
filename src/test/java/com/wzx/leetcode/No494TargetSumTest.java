package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No494TargetSumTest {

  private final int[] nums1 = {1, 1, 1, 1, 1};
  private final int[] nums2 = {7, 9, 3, 8, 0, 2, 4, 8, 3, 9};

  @Test
  public void findTargetSumWays() {
    No494TargetSum solution = new No494TargetSum();
    assertEquals(5, solution.findTargetSumWays(nums1, 3));
    assertEquals(0, solution.findTargetSumWays(nums2, 0));
  }
}