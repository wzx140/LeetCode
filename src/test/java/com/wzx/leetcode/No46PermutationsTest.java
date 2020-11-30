package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class No46PermutationsTest {

  private final int[] nums1 = {1, 2, 3};
  private final List<List<Integer>> res1 = Arrays.asList(
          Arrays.asList(1, 2, 3),
          Arrays.asList(1, 3, 2),
          Arrays.asList(2, 1, 3),
          Arrays.asList(2, 3, 1),
          Arrays.asList(3, 1, 2),
          Arrays.asList(3, 2, 1));

  private final int[] nums2 = {0, 1};
  private final List<List<Integer>> res2 = Arrays.asList(
          Arrays.asList(0, 1),
          Arrays.asList(1, 0));

  private final int[] nums3 = {1};
  private final List<List<Integer>> res3 = Collections.singletonList(Collections.singletonList(1));

  @Test
  public void permute() {
    No46Permutations solution = new No46Permutations();

    List<List<Integer>> ret1 = solution.permute(nums1);
    assertTrue(ret1.containsAll(res1));
    assertTrue(res1.containsAll(ret1));

    List<List<Integer>> ret2 = solution.permute(nums2);
    assertTrue(ret2.containsAll(res2));
    assertTrue(res2.containsAll(ret2));

    List<List<Integer>> ret3 = solution.permute(nums3);
    assertTrue(ret3.containsAll(res3));
    assertTrue(res3.containsAll(ret3));
  }
}