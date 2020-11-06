package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No43NumberOfOccurrencesOf1InAnIntegerTest {

  @Test
  public void countDigitOne() {
    No43NumberOfOccurrencesOf1InAnInteger solution = new No43NumberOfOccurrencesOf1InAnInteger();
    assertEquals(6, solution.countDigitOne(13));
    assertEquals(1, solution.countDigitOne(1));
  }
}