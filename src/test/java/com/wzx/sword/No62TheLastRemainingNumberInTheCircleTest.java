package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No62TheLastRemainingNumberInTheCircleTest {

  @Test
  public void lastRemaining1() {
    No62TheLastRemainingNumberInTheCircle solution = new No62TheLastRemainingNumberInTheCircle();
    assertEquals(3, solution.lastRemaining1(5, 3));
    assertEquals(2, solution.lastRemaining1(10, 17));
  }

  @Test
  public void lastRemaining2() {
    No62TheLastRemainingNumberInTheCircle solution = new No62TheLastRemainingNumberInTheCircle();
    assertEquals(3, solution.lastRemaining2(5, 3));
    assertEquals(2, solution.lastRemaining2(10, 17));
  }
}