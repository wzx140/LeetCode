package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class No38StringArrangementTest {

  private final String str = "abc";
  private final String[] res = {
    "abc",
    "acb",
    "bac",
    "bca",
    "cab",
    "cba"
  };

  @Test
  public void permutation() {
    No38StringArrangement solution = new No38StringArrangement();
    assertArrayEquals(res, solution.permutation(str));
  }
}