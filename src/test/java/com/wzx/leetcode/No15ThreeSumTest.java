package com.wzx.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class No15ThreeSumTest {

  private final int[] nums1 = {-1, 0, 1, 2, -1, -4};
  private final int[] nums2 = {0, 0, 0, 0};
  private final int[] nums3 = {-1, 0, 1, 0};
  private final List<List<Integer>> res1 = new ArrayList<>();
  private final List<List<Integer>> res2 = new ArrayList<>();
  private final List<List<Integer>> res3 = new ArrayList<>();

  @Before
  public void setUp() {
    res1.add(Arrays.asList(-1, -1, 2));
    res1.add(Arrays.asList(-1, 0, 1));
    res2.add(Arrays.asList(0, 0, 0));
    res3.add(Arrays.asList(-1, 0, 1));
  }

  @Test
  public void threeSum1() {
    No15ThreeSum solution = new No15ThreeSum();
    assertEquals(res1, solution.threeSum1(nums1));
    assertEquals(res2, solution.threeSum1(nums2));
    assertEquals(res3, solution.threeSum1(nums3));
    assertEquals(new ArrayList<ArrayList<Integer>>(), solution.threeSum1(new int[0]));
    assertEquals(new ArrayList<ArrayList<Integer>>(), solution.threeSum1(new int[]{0}));
  }

  @Test
  public void threeSum2() {
    No15ThreeSum solution = new No15ThreeSum();
    assertEquals(res1, solution.threeSum2(nums1));
    assertEquals(res2, solution.threeSum2(nums2));
    assertEquals(res3, solution.threeSum2(nums3));
    assertEquals(new ArrayList<ArrayList<Integer>>(), solution.threeSum2(new int[0]));
    assertEquals(new ArrayList<ArrayList<Integer>>(), solution.threeSum2(new int[]{0}));
  }
}