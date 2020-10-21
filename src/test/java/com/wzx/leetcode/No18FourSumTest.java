package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class No18FourSumTest {

  private final int[] nums = {1, 0, -1, 0, -2, 2};
  private final List<List<Integer>> res = Arrays.asList(Arrays.asList(-2, -1, 1, 2),
          Arrays.asList(-2, 0, 0, 2),
          Arrays.asList(-1, 0, 0, 1));

  @Test
  public void fourSum() {
    No18FourSum solution = new No18FourSum();
    assertEquals(res, solution.fourSum(nums, 0));
    assertEquals(Collections.emptyList(), solution.fourSum(new int[0], 0));
  }
}