package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No496NextGreaterElement1Test {

  private final int[] nums11 = {4, 1, 2};
  private final int[] nums12 = {1, 3, 4, 2};
  private final int[] res1 = {-1, 3, -1};
  private final int[] nums21 = {2, 4};
  private final int[] nums22 = {1, 2, 3, 4};
  private final int[] res2 = {3, -1};

  @Test
  public void nextGreaterElement() {
    No496NextGreaterElement1 solution = new No496NextGreaterElement1();
    assertArrayEquals(res1, solution.nextGreaterElement(nums11, nums12));
    assertArrayEquals(res2, solution.nextGreaterElement(nums21, nums22));
  }
}