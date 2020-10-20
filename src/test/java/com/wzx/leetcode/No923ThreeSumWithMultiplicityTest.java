package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No923ThreeSumWithMultiplicityTest {

  private final int[] nums1 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
  private final int[] nums2 = {1, 1, 2, 2, 2, 2};

  @Test
  public void threeSumMulti() {
    No923ThreeSumWithMultiplicity solution = new No923ThreeSumWithMultiplicity();
    assertEquals(20, solution.threeSumMulti(nums1, 8));
    assertEquals(12, solution.threeSumMulti(nums2, 5));
  }
}