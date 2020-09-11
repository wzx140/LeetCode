package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No16NumOfOneInBinaryTest {

  @Test
  public void numberOf1() {
    assertEquals(2, No16NumOfOneInBinary.NumberOf1(9));
    assertEquals(32, No16NumOfOneInBinary.NumberOf1(-1));
  }

  @Test
  public void numberOf2() {
    assertEquals(2, No16NumOfOneInBinary.NumberOf2(9));
    assertEquals(32, No16NumOfOneInBinary.NumberOf2(-1));
  }
}