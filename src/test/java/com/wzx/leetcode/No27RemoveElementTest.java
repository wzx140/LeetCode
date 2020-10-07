package com.wzx.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No27RemoveElementTest {

  private int[] nums1 = null;
  private int[] nums2 = null;

  @Before
  public void setUp() {
    nums1 = new int[]{3, 2, 2, 3};
    nums2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
  }

  @Test
  public void removeElement1() {
    No27RemoveElement solution = new No27RemoveElement();
    assertEquals(2, solution.removeElement1(nums1, 3));
    int[] res1 = Arrays.copyOf(nums1, 2);
    Arrays.sort(res1);
    assertArrayEquals(new int[]{2, 2}, res1);
    assertEquals(5, solution.removeElement1(nums2, 2));
    int[] res2 = Arrays.copyOf(nums2, 5);
    Arrays.sort(res2);
    assertArrayEquals(new int[]{0, 0, 1, 3, 4}, res2);
  }

  @Test
  public void removeElement2() {
    No27RemoveElement solution = new No27RemoveElement();
    assertEquals(2, solution.removeElement2(nums1, 3));
    int[] res1 = Arrays.copyOf(nums1, 2);
    Arrays.sort(res1);
    assertArrayEquals(new int[]{2, 2}, res1);
    assertEquals(5, solution.removeElement2(nums2, 2));
    int[] res2 = Arrays.copyOf(nums2, 5);
    Arrays.sort(res2);
    assertArrayEquals(new int[]{0, 0, 1, 3, 4}, res2);
  }
}