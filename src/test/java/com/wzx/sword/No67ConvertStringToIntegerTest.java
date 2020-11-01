package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No67ConvertStringToIntegerTest {

  @Test
  public void strToInt() {
    No67ConvertStringToInteger solution = new No67ConvertStringToInteger();
    assertEquals(42, solution.strToInt("42"));
    assertEquals(-42, solution.strToInt("   -42"));
    assertEquals(4193, solution.strToInt("4193 with words"));
    assertEquals(0, solution.strToInt("words and 987"));
    assertEquals(Integer.MIN_VALUE, solution.strToInt("-91283472332"));
  }
}