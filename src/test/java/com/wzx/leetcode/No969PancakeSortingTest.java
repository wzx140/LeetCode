package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class No969PancakeSortingTest {

  private final int[] arr1 = {3, 2, 4, 1};
  private final List<Integer> res11 = Arrays.asList(4, 2, 4, 3);
  private final List<Integer> res12 = Arrays.asList(3, 4, 2, 3, 1, 2);
  private final int[] arr2 = {1, 2, 3};
  private final List<Integer> res21 = Collections.emptyList();
  private final List<Integer> res22 = Arrays.asList(3, 3, 2, 2);

  @Test
  public void pancakeSort() {
    No969PancakeSorting solution = new No969PancakeSorting();
    List<Integer> ret1 = solution.pancakeSort(arr1);
    assertTrue(res11.equals(ret1) || res12.equals(ret1));
    List<Integer> ret2 = solution.pancakeSort(arr2);
    assertTrue(res21.equals(ret2) || res22.equals(ret2));
  }
}