package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No66BuildAnArrayOfProductsTest {

  private final int[] input = {1, 2, 3, 4, 5};
  private final int[] output = {120, 60, 40, 30, 24};

  @Test
  public void constructArr() {
    No66BuildAnArrayOfProducts solution = new No66BuildAnArrayOfProducts();
    assertArrayEquals(output, solution.constructArr(input));
  }
}