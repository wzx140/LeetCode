package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class No448FindAllNumbersDisappearedInAnArrayTest {

  private final int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
  private final List<Integer> res = Arrays.asList(5, 6);

  @Test
  public void findDisappearedNumbers1() {
    No448FindAllNumbersDisappearedInAnArray solution = new No448FindAllNumbersDisappearedInAnArray();
    assertEquals(res, solution.findDisappearedNumbers1(nums));
  }

  @Test
  public void findDisappearedNumbers2() {
    No448FindAllNumbersDisappearedInAnArray solution = new No448FindAllNumbersDisappearedInAnArray();
    assertEquals(res, solution.findDisappearedNumbers2(nums));
  }

  @Test
  public void findDisappearedNumbers3() {
    No448FindAllNumbersDisappearedInAnArray solution = new No448FindAllNumbersDisappearedInAnArray();
    assertEquals(res, solution.findDisappearedNumbers3(nums));
  }
}