package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No45JumpGameIITest {

  private final int[] nums1 = {2, 3, 1, 1, 4};
  private final int[] nums2 = {2, 3, 0, 1, 4};

  @Test
  public void jump1() {
    No45JumpGameII solution = new No45JumpGameII();
    assertEquals(2, solution.jump1(nums1));
    assertEquals(2, solution.jump1(nums2));
  }

  @Test
  public void jump2() {
    No45JumpGameII solution = new No45JumpGameII();
    assertEquals(2, solution.jump2(nums1));
    assertEquals(2, solution.jump2(nums2));
  }

  @Test
  public void jump3() {
    No45JumpGameII solution = new No45JumpGameII();
    assertEquals(2, solution.jump3(nums1));
    assertEquals(2, solution.jump3(nums2));
  }
}