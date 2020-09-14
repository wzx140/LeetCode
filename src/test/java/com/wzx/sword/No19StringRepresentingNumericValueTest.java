package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No19StringRepresentingNumericValueTest {

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
  public void isNumeric1() {
    assertTrue(No19StringRepresentingNumericValue.isNumeric1(s11.toCharArray()));
    assertTrue(No19StringRepresentingNumericValue.isNumeric1(s12.toCharArray()));
    assertTrue(No19StringRepresentingNumericValue.isNumeric1(s13.toCharArray()));
    assertTrue(No19StringRepresentingNumericValue.isNumeric1(s14.toCharArray()));
    assertTrue(No19StringRepresentingNumericValue.isNumeric1(s15.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric1(s21.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric1(s22.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric1(s23.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric1(s24.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric1(s25.toCharArray()));
  }

  @Test
  public void isNumeric2() {
    assertTrue(No19StringRepresentingNumericValue.isNumeric2(s11.toCharArray()));
    assertTrue(No19StringRepresentingNumericValue.isNumeric2(s12.toCharArray()));
    assertTrue(No19StringRepresentingNumericValue.isNumeric2(s13.toCharArray()));
    assertTrue(No19StringRepresentingNumericValue.isNumeric2(s14.toCharArray()));
    assertTrue(No19StringRepresentingNumericValue.isNumeric2(s15.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric2(s21.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric2(s22.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric2(s23.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric2(s24.toCharArray()));
    assertFalse(No19StringRepresentingNumericValue.isNumeric2(s25.toCharArray()));
  }
}