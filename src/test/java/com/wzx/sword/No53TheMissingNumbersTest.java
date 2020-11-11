package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No53TheMissingNumbersTest {

  private final int[] nums1 = {0, 1, 3};
  private final int[] nums2 = {0, 1, 2, 3, 4, 5, 6, 7, 9};
  private final int[] nums3 = {0, 2, 3};

  @Test
  public void missingNumber1() {
    No53TheMissingNumbers solution = new No53TheMissingNumbers();
    assertEquals(2, solution.missingNumber1(nums1));
    assertEquals(8, solution.missingNumber1(nums2));
    assertEquals(1, solution.missingNumber1(nums3));
  }

  @Test
  public void missingNumber2() {
    No53TheMissingNumbers solution = new No53TheMissingNumbers();
    assertEquals(2, solution.missingNumber2(nums1));
    assertEquals(8, solution.missingNumber2(nums2));
    assertEquals(1, solution.missingNumber2(nums3));
  }

  @Test
  public void missingNumber3() {
    No53TheMissingNumbers solution = new No53TheMissingNumbers();
    assertEquals(2, solution.missingNumber3(nums1));
    assertEquals(8, solution.missingNumber3(nums2));
    assertEquals(1, solution.missingNumber3(nums3));
  }
}