package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class No77CombinationsTest {

  private final List<List<Integer>> res1 = Arrays.asList(
          Arrays.asList(2, 4),
          Arrays.asList(3, 4),
          Arrays.asList(2, 3),
          Arrays.asList(1, 2),
          Arrays.asList(1, 3),
          Arrays.asList(1, 4));

  private final List<List<Integer>> res2 = Collections.singletonList(Collections.singletonList(1));

  @Test
  public void combine() {
    No77Combinations solution = new No77Combinations();
    List<List<Integer>> ret1 = solution.combine(4, 2);
    assertTrue(res1.containsAll(ret1));
    assertTrue(ret1.containsAll(res1));
    List<List<Integer>> ret2 = solution.combine(1, 1);
    assertTrue(res2.containsAll(ret2));
    assertTrue(ret2.containsAll(res2));
  }
}