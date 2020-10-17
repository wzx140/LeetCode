package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No3DuplicateNumTest {

  private final int[] array1 = new int[]{3, 0, 2, 1, 3, 2};
  private final int[] array2 = new int[]{4, 0, 2, 1, 3, 5};

  @Test
  public void findRepeatNumber1() {
    No3DuplicateNum solution = new No3DuplicateNum();
    int res = solution.findRepeatNumber1(array1);
    assertTrue(2 == res || 3 == res);
    assertEquals(-1, solution.findRepeatNumber1(array2));
    assertEquals(-1, solution.findRepeatNumber1(new int[0]));
  }

  @Test
  public void findRepeatNumber2() {
    No3DuplicateNum solution = new No3DuplicateNum();
    int res = solution.findRepeatNumber2(array1);
    assertTrue(2 == res || 3 == res);
    assertEquals(-1, solution.findRepeatNumber2(array2));
    assertEquals(-1, solution.findRepeatNumber2(new int[0]));
  }

  @Test
  public void findRepeatNumber3() {
    No3DuplicateNum solution = new No3DuplicateNum();
    int res = solution.findRepeatNumber3(array1);
    assertTrue(2 == res || 3 == res);
    assertEquals(-1, solution.findRepeatNumber3(array2));
    assertEquals(-1, solution.findRepeatNumber3(new int[0]));
  }
}