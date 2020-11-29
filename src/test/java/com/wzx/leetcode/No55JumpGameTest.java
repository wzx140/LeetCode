package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No55JumpGameTest {

  private final int[] nums1 = {2, 3, 1, 1, 4};
  private final int[] nums2 = {3, 2, 1, 0, 4};

  @Test
  public void canJump1() {
    No55JumpGame solution = new No55JumpGame();
    assertTrue(solution.canJump1(nums1));
    assertFalse(solution.canJump1(nums2));
  }

  @Test
  public void canJump2() {
    No55JumpGame solution = new No55JumpGame();
    assertTrue(solution.canJump2(nums1));
    assertFalse(solution.canJump2(nums2));
  }

  @Test
  public void canJump3() {
    No55JumpGame solution = new No55JumpGame();
    assertTrue(solution.canJump3(nums1));
    assertFalse(solution.canJump3(nums2));
  }
}