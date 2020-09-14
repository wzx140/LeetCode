package com.wzx.sword;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class No21AdjustArrayOrder2Test {

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
    No21AdjustArrayOrder2.reOrderArray1(array1);
    No21AdjustArrayOrder2.reOrderArray1(array2);
    assertEquals(getOddSet(res1), getOddSet(array1));
    assertEquals(getEvenSet(res1), getEvenSet(array1));
    assertEquals(getOddSet(res2), getOddSet(array2));
    assertEquals(getEvenSet(res2), getEvenSet(array2));
  }

  private Set<Integer> getOddSet(int[] array) {
    return Arrays.stream(array).boxed()
            .limit((array.length + 1) / 2)
            .collect(Collectors.toSet());
  }

  private Set<Integer> getEvenSet(int[] array) {
    return Arrays.stream(array).boxed()
            .skip((array.length + 1) / 2)
            .collect(Collectors.toSet());
  }
}