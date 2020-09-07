package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No10RotateMinNumTest {

  private final int[] array1 = new int[]{3, 4, 5, 1, 2};
  private final int[] array2 = new int[]{3, 4, 4, 5, 1, 2};
  private final int[] array3 = new int[]{1};


  @Test
  public void minNumberInRotateArray() {
    assertEquals(0, No10RotateMinNum.minNumberInRotateArray(null));
    assertEquals(0, No10RotateMinNum.minNumberInRotateArray(new int[0]));
    assertEquals(1, No10RotateMinNum.minNumberInRotateArray(array1));
    assertEquals(1, No10RotateMinNum.minNumberInRotateArray(array2));
    assertEquals(1, No10RotateMinNum.minNumberInRotateArray(array3));
  }
}