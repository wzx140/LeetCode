package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No912SortAnArrayTest {

  private final int[] nums1 = {5, 2, 3, 1};
  private final int[] res1 = {1, 2, 3, 5};

  private final int[] nums2 = {5, 1, 1, 2, 0, 0};
  private final int[] res2 = {0, 0, 1, 1, 2, 5};

  @Test
  public void sortArray1() {
    No912SortAnArray solution = new No912SortAnArray();
    assertArrayEquals(res1, solution.sortArray1(nums1));
    assertArrayEquals(res2, solution.sortArray1(nums2));
  }

  @Test
  public void sortArray2() {
    No912SortAnArray solution = new No912SortAnArray();
    assertArrayEquals(res1, solution.sortArray2(nums1));
    assertArrayEquals(res2, solution.sortArray2(nums2));
  }

  @Test
  public void sortArray3() {
    No912SortAnArray solution = new No912SortAnArray();
    assertArrayEquals(res1, solution.sortArray3(nums1));
    assertArrayEquals(res2, solution.sortArray3(nums2));
  }

  @Test
  public void sortArray4() {
    No912SortAnArray solution = new No912SortAnArray();
    assertArrayEquals(res1, solution.sortArray4(nums1));
    assertArrayEquals(res2, solution.sortArray4(nums2));
  }

  @Test
  public void sortArray5() {
    No912SortAnArray solution = new No912SortAnArray();
    assertArrayEquals(res1, solution.sortArray5(nums1));
    assertArrayEquals(res2, solution.sortArray5(nums2));
  }

  @Test
  public void sortArray6() {
    No912SortAnArray solution = new No912SortAnArray();
    assertArrayEquals(res1, solution.sortArray6(nums1));
    assertArrayEquals(res2, solution.sortArray6(nums2));
  }

  @Test
  public void sortArray7() {
    No912SortAnArray solution = new No912SortAnArray();
    assertArrayEquals(res1, solution.sortArray7(nums1));
    assertArrayEquals(res2, solution.sortArray7(nums2));
  }

  @Test
  public void sortArray8() {
    No912SortAnArray solution = new No912SortAnArray();
    assertArrayEquals(res1, solution.sortArray8(nums1));
    assertArrayEquals(res2, solution.sortArray8(nums2));
  }

  @Test
  public void sortArray9() {
    No912SortAnArray solution = new No912SortAnArray();
    assertArrayEquals(res1, solution.sortArray9(nums1));
    assertArrayEquals(res2, solution.sortArray9(nums2));
  }
}