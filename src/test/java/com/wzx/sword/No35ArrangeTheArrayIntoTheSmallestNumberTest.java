package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No35ArrangeTheArrayIntoTheSmallestNumberTest {

  private final int[] array1 = {3, 32, 321};
  private final int[] array2 = {3334,3,3333332};

  @Test
  public void printMinNumber() {
    No35ArrangeTheArrayIntoTheSmallestNumber solution = new No35ArrangeTheArrayIntoTheSmallestNumber();
    assertEquals("321323", solution.PrintMinNumber(array1));
    assertEquals("333333233334", solution.PrintMinNumber(array2));
  }
}