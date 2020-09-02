package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No2DuplicateNum1Test {

  private final int[] array1 = new int[]{3, 0, 2, 1, 3, 2};
  private final int[] array2 = new int[]{4, 0, 2, 1, 3, 5};

  @Test
  public void findDuplicate1() {
    int res = No2DuplicateNum1.findDuplicate1(array1);
    assertTrue(2 == res || 3 == res);
    assertEquals(-1, No2DuplicateNum1.findDuplicate1(array2));
    assertEquals(-1, No2DuplicateNum1.findDuplicate1(new int[0]));
  }

  @Test
  public void findDuplicate2() {
    int res = No2DuplicateNum1.findDuplicate2(array1);
    assertTrue(2 == res || 3 == res);
    assertEquals(-1, No2DuplicateNum1.findDuplicate2(array2));
    assertEquals(-1, No2DuplicateNum1.findDuplicate2(new int[0]));
  }

  @Test
  public void findDuplicate3() {
    int res = No2DuplicateNum1.findDuplicate3(array1);
    assertTrue(2 == res || 3 == res);
    assertEquals(-1, No2DuplicateNum1.findDuplicate3(array2));
    assertEquals(-1, No2DuplicateNum1.findDuplicate3(new int[0]));
  }
}