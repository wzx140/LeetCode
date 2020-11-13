package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No347TopKFrequentElementsTest {

  private final int[] nums1 = {1, 1, 1, 2, 2, 3};
  private final int[] res1 = {1, 2};
  private final int[] nums2 = {1};
  private final int[] res2 = {1};

  @Test
  public void topKFrequent() {
    No347TopKFrequentElements solution = new No347TopKFrequentElements();
    assertArrayEquals(res1, solution.topKFrequent(nums1, 2));
    assertArrayEquals(res2, solution.topKFrequent(nums2, 1));
  }
}