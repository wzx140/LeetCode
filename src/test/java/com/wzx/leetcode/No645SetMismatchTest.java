package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No645SetMismatchTest {

  private final int[] nums = {1, 2, 2, 4};
  private final int[] res = {2, 3};

  @Test
  public void findErrorNums1() {
    No645SetMismatch solution = new No645SetMismatch();
    assertArrayEquals(res, solution.findErrorNums1(nums));
  }

  @Test
  public void findErrorNums2() {
    No645SetMismatch solution = new No645SetMismatch();
    assertArrayEquals(res, solution.findErrorNums2(nums));
  }
}