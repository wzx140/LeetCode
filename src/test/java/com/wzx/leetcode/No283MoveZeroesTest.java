package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No283MoveZeroesTest {

  private final int[] nums = {0, 1, 0, 3, 12};

  @Test
  public void moveZeroes1() {
    No283MoveZeroes solution = new No283MoveZeroes();
    solution.moveZeroes1(nums);
    assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
  }

  @Test
  public void moveZeroes2() {
    No283MoveZeroes solution = new No283MoveZeroes();
    solution.moveZeroes2(nums);
    assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
  }
}