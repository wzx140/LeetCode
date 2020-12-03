package com.wzx.leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

public class No213HouseRobber2Test {

  private final int[] nums1 = {2, 3, 2};
  private final int[] nums2 = {1, 2, 3, 1};
  private final int[] nums3 = {0};
  private final int[] nums4 = {200, 3, 140, 20, 10};

  @Test
  public void rob() {
    No213HouseRobber2 solution = new No213HouseRobber2();
    assertEquals(3, solution.rob(nums1));
    assertEquals(4, solution.rob(nums2));
    assertEquals(0, solution.rob(nums3));
    assertEquals(340, solution.rob(nums4));
  }
}