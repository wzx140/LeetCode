package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No560SubarraySumEqualsKTest {

  private final int[] nums1 = {1, 1, 1};
  private final int[] nums2 = {1, 2, 3};

  @Test
  public void subarraySum() {
    No560SubarraySumEqualsK solution = new No560SubarraySumEqualsK();
    assertEquals(2, solution.subarraySum(nums1, 2));
    assertEquals(2, solution.subarraySum(nums2, 3));
  }
}