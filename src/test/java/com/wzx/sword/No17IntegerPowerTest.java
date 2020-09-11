package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No17IntegerPowerTest {

  @Test
  public void power1() {
    assertEquals(0.25, No17IntegerPower.power1(2, -2), 0);
    assertEquals(4, No17IntegerPower.power1(2, 2), 0);
    assertEquals(1, No17IntegerPower.power1(2, 0), 0);
    assertEquals(4, No17IntegerPower.power1(-2, 2), 0);
    assertEquals(-8, No17IntegerPower.power1(-2, 3), 0);
    assertEquals(0, No17IntegerPower.power1(0, 2), 0);
  }

  @Test
  public void power2() {
    assertEquals(0.25, No17IntegerPower.power2(2, -2), 0);
    assertEquals(4, No17IntegerPower.power2(2, 2), 0);
    assertEquals(1, No17IntegerPower.power2(2, 0), 0);
    assertEquals(4, No17IntegerPower.power2(-2, 2), 0);
    assertEquals(-8, No17IntegerPower.power2(-2, 3), 0);
    assertEquals(0, No17IntegerPower.power2(0, 2), 0);
  }
}