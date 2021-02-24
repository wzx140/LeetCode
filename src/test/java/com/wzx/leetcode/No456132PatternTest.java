package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class No456132PatternTest {

  private final int[] nums1 = {1, 2, 3, 4};
  private final int[] nums2 = {3, 1, 4, 2};
  private final int[] nums3 = {-1, 3, 2, 0};

  @Test
  public void find132pattern() {
    No456132Pattern solution = new No456132Pattern();
    assertFalse(solution.find132pattern(nums1));
    assertTrue(solution.find132pattern(nums2));
    assertTrue(solution.find132pattern(nums3));
  }
}