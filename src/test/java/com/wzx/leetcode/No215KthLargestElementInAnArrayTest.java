package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No215KthLargestElementInAnArrayTest {

  private final int[] nums1 = {3, 2, 1, 5, 6, 4};
  private final int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};

  @Test
  public void findKthLargest1() {
    No215KthLargestElementInAnArray solution = new No215KthLargestElementInAnArray();
    assertEquals(5, solution.findKthLargest1(nums1, 2));
    assertEquals(4, solution.findKthLargest1(nums2, 4));
  }

  @Test
  public void findKthLargest2() {
    No215KthLargestElementInAnArray solution = new No215KthLargestElementInAnArray();
    assertEquals(5, solution.findKthLargest2(nums1, 2));
    assertEquals(4, solution.findKthLargest2(nums2, 4));
    assertEquals(2, solution.findKthLargest2(new int[]{-1, 2, 0}, 1));
  }
}