package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No44ADigitInASequenceOfNumbersTest {

  @Test
  public void findNthDigit() {
    No44ADigitInASequenceOfNumbers solution = new No44ADigitInASequenceOfNumbers();
    assertEquals(3, solution.findNthDigit(3));
    assertEquals(0, solution.findNthDigit(11));
    assertEquals(1, solution.findNthDigit(1000000000));
  }
}