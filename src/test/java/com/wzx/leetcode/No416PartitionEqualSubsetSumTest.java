package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No416PartitionEqualSubsetSumTest {

  private final int[] nums1 = {1, 5, 11, 5};
  private final int[] nums2 = {1, 2, 3, 5};
  private final int[] nums3 = {1, 2, 5};
  private final int[] nums4 = {3, 3, 3, 4, 5};

  @Test
  public void canPartition() {
    No416PartitionEqualSubsetSum solution = new No416PartitionEqualSubsetSum();
    assertTrue(solution.canPartition(nums1));
    assertFalse(solution.canPartition(nums2));
    assertFalse(solution.canPartition(nums3));
    assertTrue(solution.canPartition(nums4));
  }
}