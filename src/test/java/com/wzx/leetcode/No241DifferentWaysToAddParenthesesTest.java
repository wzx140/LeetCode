package com.wzx.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class No241DifferentWaysToAddParenthesesTest {

  private final String str1 = "2-1-1";
  private final List<Integer> res1 = Arrays.asList(0, 2);
  private final String str2 = "2*3-4*5";
  private final List<Integer> res2 = Arrays.asList(-34, -14, -10, -10, 10);

  @Test
  public void diffWaysToCompute() {
    No241DifferentWaysToAddParentheses solution = new No241DifferentWaysToAddParentheses();
    List<Integer> ret1 = solution.diffWaysToCompute(str1);
    assertTrue(ret1.containsAll(res1));
    assertTrue(res1.containsAll(ret1));
    List<Integer> ret2 = solution.diffWaysToCompute(str2);
    assertTrue(ret2.containsAll(res2));
    assertTrue(res2.containsAll(ret2));
  }
}