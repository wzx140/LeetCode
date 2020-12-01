package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No752OpenTheLockTest {

  private final String[] deadends1 = {"0201", "0101", "0102", "1212", "2002"};
  private final String target1 = "0202";
  private final String[] deadends2 = {"8888"};
  private final String target2 = "0009";
  private final String[] deadends3 = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
  private final String target3 = "8888";
  private final String[] deadends4 = {"0000"};
  private final String target4 = "8888";

  @Test
  public void openLock1() {
    No752OpenTheLock solution = new No752OpenTheLock();
    assertEquals(6, solution.openLock1(deadends1, target1));
    assertEquals(1, solution.openLock1(deadends2, target2));
    assertEquals(-1, solution.openLock1(deadends3, target3));
    assertEquals(-1, solution.openLock1(deadends4, target4));
  }

  @Test
  public void openLock2() {
    No752OpenTheLock solution = new No752OpenTheLock();
    assertEquals(6, solution.openLock2(deadends1, target1));
    assertEquals(1, solution.openLock2(deadends2, target2));
    assertEquals(-1, solution.openLock2(deadends3, target3));
    assertEquals(-1, solution.openLock2(deadends4, target4));
  }
}