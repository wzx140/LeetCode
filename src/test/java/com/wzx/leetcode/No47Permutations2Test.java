package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class No47Permutations2Test {

  private final int[] nums1 = {1, 1, 2};
  private final List<List<Integer>> res1 = Arrays.asList(
          Arrays.asList(1, 1, 2),
          Arrays.asList(1, 2, 1),
          Arrays.asList(2, 1, 1));


  private final int[] nums2 = {1, 2, 3};
  private final List<List<Integer>> res2 = Arrays.asList(
          Arrays.asList(1, 2, 3),
          Arrays.asList(1, 3, 2),
          Arrays.asList(2, 1, 3),
          Arrays.asList(2, 3, 1),
          Arrays.asList(3, 1, 2),
          Arrays.asList(3, 2, 1));

  @Test
  public void permuteUnique() {
    No47Permutations2 solution = new No47Permutations2();

    List<List<Integer>> ret1 = solution.permuteUnique(nums1);
    assertTrue(ret1.containsAll(res1));
    assertTrue(res1.containsAll(ret1));

    List<List<Integer>> ret2 = solution.permuteUnique(nums2);
    assertTrue(ret2.containsAll(res2));
    assertTrue(res2.containsAll(ret2));
  }
}