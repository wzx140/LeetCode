package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No56NumberOfOccurrencesOfNumbersInTheArray2Test {

  private final int[] nums1 = {3, 4, 3, 3};
  private final int[] nums2 = {9, 1, 7, 9, 7, 9, 7};

  @Test
  public void singleNumber1() {
    No56NumberOfOccurrencesOfNumbersInTheArray2 solution = new No56NumberOfOccurrencesOfNumbersInTheArray2();
    assertEquals(4, solution.singleNumber1(nums1));
    assertEquals(1, solution.singleNumber1(nums2));
  }

  @Test
  public void singleNumber2() {
    No56NumberOfOccurrencesOfNumbersInTheArray2 solution = new No56NumberOfOccurrencesOfNumbersInTheArray2();
    assertEquals(4, solution.singleNumber2(nums1));
    assertEquals(1, solution.singleNumber2(nums2));
  }
}