package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No3TwoDimensionalArraySearchTest {

  private final int[][] array = {{1, 2, 8, 9}, {2, 4, 6, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

  @Test
  public void find() {
    assertTrue(No3TwoDimensionalArraySearch.Find(7, array));
    assertFalse(No3TwoDimensionalArraySearch.Find(16, array));
    assertFalse(No3TwoDimensionalArraySearch.Find(0, new int[0][0]));
  }
}