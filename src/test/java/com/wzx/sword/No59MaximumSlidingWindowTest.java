package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No59MaximumSlidingWindowTest {

  private final int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
  private final int[] res = {3,3,5,5,6,7};

  @Test
  public void maxSlidingWindow() {
    No59MaximumSlidingWindow solution = new No59MaximumSlidingWindow();
    assertArrayEquals(res, solution.maxSlidingWindow(nums, 3));
  }
}