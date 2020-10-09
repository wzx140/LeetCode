package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No33NumberOfOccurrencesOf1InAnIntegerTest {

  @Test
  public void numberOf1Between1AndN_Solution() {
    No33NumberOfOccurrencesOf1InAnInteger solution = new No33NumberOfOccurrencesOf1InAnInteger();
    assertEquals(6, solution.NumberOf1Between1AndN_Solution(13));
    assertEquals(1, solution.NumberOf1Between1AndN_Solution(1));
  }
}