package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No300LongestIncreasingSubsequenceTest {

  private final int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
  private final int[] nums2 = {0, 1, 0, 3, 2, 3};
  private final int[] nums3 = {7, 7, 7, 7, 7, 7, 7};

  @Test
  public void lengthOfLIS() {
    No300LongestIncreasingSubsequence solution = new No300LongestIncreasingSubsequence();
    assertEquals(4, solution.lengthOfLIS(nums1));
    assertEquals(4, solution.lengthOfLIS(nums2));
    assertEquals(1, solution.lengthOfLIS(nums3));
  }
}