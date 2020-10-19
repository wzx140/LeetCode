package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No1TwoSumTest {

  private final int[] nums1 = {2, 7, 11, 15};
  private final int[] res1 = {0, 1};
  private final int[] nums2 = {3, 2, 4};
  private final int[] res2 = {1, 2};
  private final int[] nums3 = {3, 3};
  private final int[] res3 = {0, 1};

  @Test
  public void twoSum2() {
    No1TwoSum solution = new No1TwoSum();
    assertArrayEquals(res1, solution.twoSum(nums1, 9));
    assertArrayEquals(res2, solution.twoSum(nums2, 6));
    assertArrayEquals(res3, solution.twoSum(nums3, 6));
  }
}