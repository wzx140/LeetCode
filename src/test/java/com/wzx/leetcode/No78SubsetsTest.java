package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class No78SubsetsTest {

  private final int[] nums1 = {1, 2, 3};
  private final List<List<Integer>> res1 = Arrays.asList(
          Arrays.asList(),
          Collections.singletonList(1),
          Collections.singletonList(2),
          Collections.singletonList(3),
          Arrays.asList(1, 2),
          Arrays.asList(1, 3),
          Arrays.asList(2, 3),
          Arrays.asList(1, 2, 3)
  );

  private final int[] nums2 = {0};
  private final List<List<Integer>> res2 = Arrays.asList(
          Arrays.asList(),
          Collections.singletonList(0)
  );

  @Test
  public void subsets() {
    No78Subsets solution = new No78Subsets();
    List<List<Integer>> ret1 = solution.subsets(nums1);
    assertTrue(res1.containsAll(ret1));
    assertTrue(ret1.containsAll(res1));
    List<List<Integer>> ret2 = solution.subsets(nums2);
    assertTrue(res2.containsAll(ret2));
    assertTrue(ret2.containsAll(res2));
  }
}