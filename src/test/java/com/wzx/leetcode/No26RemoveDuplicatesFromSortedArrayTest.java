package com.wzx.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class No26RemoveDuplicatesFromSortedArrayTest {

  private final List<Integer> res1 = Arrays.asList(1, 2);
  private final List<Integer> res2 = Arrays.asList(0, 1, 2, 3, 4);
  private int[] array1 = null;
  private int[] array2 = null;

  @Before
  public void setUp() {
    array1 = new int[]{1, 1, 2};
    array2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
  }

  @Test
  public void removeDuplicates() {
    No26RemoveDuplicatesFromSortedArray solution = new No26RemoveDuplicatesFromSortedArray();
    assertEquals(2, solution.removeDuplicates(array1));
    assertTrue(res1.containsAll(Arrays.asList(Arrays.stream(array1).boxed().toArray(Integer[]::new))));
    assertEquals(5, solution.removeDuplicates(array2));
    assertTrue(res2.containsAll(Arrays.asList(Arrays.stream(array2).boxed().toArray(Integer[]::new))));
  }
}