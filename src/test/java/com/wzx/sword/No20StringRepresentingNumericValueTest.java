package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No20StringRepresentingNumericValueTest {

  private final String s11 = "+100";
  private final String s12 = "5e2";
  private final String s13 = "-123";
  private final String s14 = "3.1416";
  private final String s15 = "-1E-16";
  private final String s21 = "12e";
  private final String s22 = "1a3.14";
  private final String s23 = "1.2.3";
  private final String s24 = "+-5";
  private final String s25 = "12e+4.3";

  @Test
  public void isNumber1() {
    No20StringRepresentingNumericValue solution = new No20StringRepresentingNumericValue();
    assertTrue(solution.isNumber1(s11));
    assertTrue(solution.isNumber1(s12));
    assertTrue(solution.isNumber1(s13));
    assertTrue(solution.isNumber1(s14));
    assertTrue(solution.isNumber1(s15));
    assertFalse(solution.isNumber1(s21));
    assertFalse(solution.isNumber1(s22));
    assertFalse(solution.isNumber1(s23));
    assertFalse(solution.isNumber1(s24));
    assertFalse(solution.isNumber1(s25));
  }

  @Test
  public void isNumber2() {
    No20StringRepresentingNumericValue solution = new No20StringRepresentingNumericValue();
    assertTrue(solution.isNumber2(s11));
    assertTrue(solution.isNumber2(s12));
    assertTrue(solution.isNumber2(s13));
    assertTrue(solution.isNumber2(s14));
    assertTrue(solution.isNumber2(s15));
    assertFalse(solution.isNumber2(s21));
    assertFalse(solution.isNumber2(s22));
    assertFalse(solution.isNumber2(s23));
    assertFalse(solution.isNumber2(s24));
    assertFalse(solution.isNumber2(s25));
  }
}