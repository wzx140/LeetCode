package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No16IntegerPowerTest {

  @Test
  public void power1() {
    No16IntegerPower solution = new No16IntegerPower();
    assertEquals(1024.00000, solution.myPow1(2.00000, 10), 0.00001);
    assertEquals(9.26100, solution.myPow1(2.1000, 3), 0.00001);
    assertEquals(0.25000, solution.myPow1(2.00000, -2), 0.00001);
  }

  @Test
  public void power2() {
    No16IntegerPower solution = new No16IntegerPower();
    assertEquals(1024.00000, solution.myPow2(2.00000, 10), 0.00001);
    assertEquals(9.26100, solution.myPow2(2.1000, 3), 0.00001);
    assertEquals(0.25000, solution.myPow2(2.00000, -2), 0.00001);
  }
}