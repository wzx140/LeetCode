package com.wzx.sword;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class No20AdjustArrayOrder1Test {

  private final int[] res1 = new int[]{1, 3, 5, 7, 2, 4, 6};
  private final int[] res2 = new int[]{1, 3, 5, 2, 4, 6};
  private int[] array1 = null;
  private int[] array2 = null;

  @Before
  public void setUp() {
    array1 = new int[]{1, 2, 3, 4, 5, 6, 7};
    array2 = new int[]{1, 2, 3, 4, 5, 6};
  }

  @Test
  public void reOrderArray1() {
    No20AdjustArrayOrder1.reOrderArray1(array1);
    No20AdjustArrayOrder1.reOrderArray1(array2);
    assertArrayEquals(res1, array1);
    assertArrayEquals(res2, array2);
  }

  @Test
  public void reOrderArray2() {
    No20AdjustArrayOrder1.reOrderArray2(array1);
    No20AdjustArrayOrder1.reOrderArray2(array2);
    assertArrayEquals(res1, array1);
    assertArrayEquals(res2, array2);
  }
}