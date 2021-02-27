package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No41FirstMissingPositiveTest {

  private final int[] nums1 = {1,2,0};
  private final int[] nums2 = {3,4,-1,1};
  private final int[] nums3 = {7,8,9,11,12};

  @Test
  public void firstMissingPositive() {
    No41FirstMissingPositive solution = new No41FirstMissingPositive();
    assertEquals(3, solution.firstMissingPositive(nums1));
    assertEquals(2, solution.firstMissingPositive(nums2));
    assertEquals(1, solution.firstMissingPositive(nums3));
  }
}