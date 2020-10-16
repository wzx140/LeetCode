package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No34FindFirstAndLastPositionOfElementInSortedArrayTest {

  private final int[] nums = {5, 7, 7, 8, 8, 10};

  @Test
  public void searchRange() {
    No34FindFirstAndLastPositionOfElementInSortedArray solution = new No34FindFirstAndLastPositionOfElementInSortedArray();
    assertArrayEquals(new int[]{3, 4}, solution.searchRange(nums, 8));
    assertArrayEquals(new int[]{-1, -1}, solution.searchRange(nums, 6));
    assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[0], 0));
  }
}