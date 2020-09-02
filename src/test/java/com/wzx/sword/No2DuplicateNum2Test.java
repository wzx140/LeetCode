package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No2DuplicateNum2Test {

  private final int[] array1 = new int[]{4, 1, 3, 2, 4, 3};
  private final int[] array2 = new int[]{5, 1, 3, 2, 4, 5};

  @Test
  public void findDuplicate1() {
    int res = No2DuplicateNum2.findDuplicate1(array1);
    assertTrue(3 == res || 4 == res);
    assertEquals(5, No2DuplicateNum2.findDuplicate1(array2));
    assertEquals(-1, No2DuplicateNum2.findDuplicate1(new int[0]));
  }

  @Test
  public void findDuplicate2() {
    int res = No2DuplicateNum2.findDuplicate2(array1);
    assertTrue(3 == res || 4 == res);
    assertEquals(5, No2DuplicateNum2.findDuplicate2(array2));
    assertEquals(-1, No2DuplicateNum2.findDuplicate2(new int[0]));
  }
}