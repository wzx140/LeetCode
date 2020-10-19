package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class No167TwoSum2InputArrayIsSortedTest {

  private final int[] nums1 = {2, 7, 11, 15};
  private final int[] res1 = {1, 2};
  private final int[] nums2 = {2,3,4};
  private final int[] res2 = {1,3};
  private final int[] nums3 = {-1,0};
  private final int[] res3 = {1,2};

  @Test
  public void twoSum() {
    No167TwoSum2InputArrayIsSorted solution = new No167TwoSum2InputArrayIsSorted();
    assertArrayEquals(res1, solution.twoSum(nums1, 9));
    assertArrayEquals(res2, solution.twoSum(nums2, 6));
    assertArrayEquals(res3, solution.twoSum(nums3, -1));
  }
}