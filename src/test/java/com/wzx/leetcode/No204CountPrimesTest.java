package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No204CountPrimesTest {

  @Test
  public void countPrimes1() {
    No204CountPrimes solution = new No204CountPrimes();
    assertEquals(4, solution.countPrimes1(10));
    assertEquals(0, solution.countPrimes1(0));
    assertEquals(0, solution.countPrimes1(1));
  }

  @Test
  public void countPrimes2() {
    No204CountPrimes solution = new No204CountPrimes();
    assertEquals(4, solution.countPrimes2(10));
    assertEquals(0, solution.countPrimes2(0));
    assertEquals(0, solution.countPrimes2(1));
  }
}