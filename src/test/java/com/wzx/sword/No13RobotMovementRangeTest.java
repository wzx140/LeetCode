package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No13RobotMovementRangeTest {

  @Test
  public void movingCount() {
    No13RobotMovementRange solution = new No13RobotMovementRange();
    assertEquals(21, solution.movingCount(5, 10, 10));
  }
}