package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No45ArrangeTheArrayIntoTheSmallestNumberTest {

  private final int[] array1 = {3, 32, 321};
  private final int[] array2 = {3334, 3, 3333332};
  private final int[] array3 = {824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};

  @Test
  public void minNumber() {
    No45ArrangeTheArrayIntoTheSmallestNumber solution = new No45ArrangeTheArrayIntoTheSmallestNumber();
    assertEquals("321323", solution.minNumber(array1));
    assertEquals("333333233334", solution.minNumber(array2));
    assertEquals("1399439856075703697382478249389609", solution.minNumber(array3));
  }
}