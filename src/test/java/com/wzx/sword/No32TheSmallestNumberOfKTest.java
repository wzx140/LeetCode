package com.wzx.sword;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class No32TheSmallestNumberOfKTest {

  private final int[] array1 = {3, 2, 1};
  private final int[] res1 = {1, 2};
  private final int[] array2 = {0, 1, 2, 1};
  private final int[] res2 = {0};

  @Test
  public void getLeastNumbers1() {
    No32TheSmallestNumberOfK solution = new No32TheSmallestNumberOfK();
    assertEquals(Arrays.stream(res1).boxed().collect(Collectors.toSet()),
            Arrays.stream(solution.getLeastNumbers1(array1, 2)).boxed().collect(Collectors.toSet()));

    assertEquals(Arrays.stream(res2).boxed().collect(Collectors.toSet()),
            Arrays.stream(solution.getLeastNumbers1(array2, 1)).boxed().collect(Collectors.toSet()));
  }

  @Test
  public void getLeastNumbers2() {
    No32TheSmallestNumberOfK solution = new No32TheSmallestNumberOfK();
    assertEquals(Arrays.stream(res1).boxed().collect(Collectors.toSet()),
            Arrays.stream(solution.getLeastNumbers2(array1, 2)).boxed().collect(Collectors.toSet()));

    assertEquals(Arrays.stream(res2).boxed().collect(Collectors.toSet()),
            Arrays.stream(solution.getLeastNumbers2(array2, 1)).boxed().collect(Collectors.toSet()));
  }

  @Test
  public void getLeastNumbers3() {
    No32TheSmallestNumberOfK solution = new No32TheSmallestNumberOfK();
    assertEquals(Arrays.stream(res1).boxed().collect(Collectors.toSet()),
            Arrays.stream(solution.getLeastNumbers3(array1, 2)).boxed().collect(Collectors.toSet()));

    assertEquals(Arrays.stream(res2).boxed().collect(Collectors.toSet()),
            Arrays.stream(solution.getLeastNumbers3(array2, 1)).boxed().collect(Collectors.toSet()));
  }
}