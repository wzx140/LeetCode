package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No34ADigitInASequenceOfNumbersTest {

  @Test
  public void findNthDigit() {
    No34ADigitInASequenceOfNumbers solution = new No34ADigitInASequenceOfNumbers();
    assertEquals(3, solution.findNthDigit(3));
    assertEquals(0, solution.findNthDigit(11));
    assertEquals(1, solution.findNthDigit(1000000000));
  }
}