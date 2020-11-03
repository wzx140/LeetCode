package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No11RotateMinNumTest {

  private final int[] array1 = new int[]{3, 4, 5, 1, 2};
  private final int[] array2 = new int[]{2, 2, 2, 0, 1};
  private final int[] array3 = new int[]{1, 3, 5};


  @Test
  public void minArray() {
    No11RotateMinNum solution = new No11RotateMinNum();
    assertEquals(1, solution.minArray(array1));
    assertEquals(0, solution.minArray(array2));
    assertEquals(1, solution.minArray(array3));
  }
}