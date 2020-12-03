package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No198HouseRobberTest {

  private final int[] nums1 = {1, 2, 3, 1};
  private final int[] nums2 = {2, 7, 9, 3, 1};

  @Test
  public void rob() {
    No198HouseRobber solution = new No198HouseRobber();
    assertEquals(4, solution.rob(nums1));
    assertEquals(12, solution.rob(nums2));
  }
}