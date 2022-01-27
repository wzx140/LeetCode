package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No474OnesAndZeroesTest {

  private final String[] str1 = new String[]{"10", "0001", "111001", "1", "0"};
  private final String[] str2 = new String[]{"10", "0", "1"};

  @Test
  public void findMaxForm() {
    No474OnesAndZeroes solution = new No474OnesAndZeroes();
    assertEquals(4, solution.findMaxForm(str1, 5, 3));
    assertEquals(2, solution.findMaxForm(str2, 1, 1));
  }
}