package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No13RobotMovementRangeTest {

  @Test
  public void movingCount() {
    No13RobotMovementRange solution = new No13RobotMovementRange();
    assertEquals(3, solution.movingCount(2, 3, 1));
    assertEquals(1, solution.movingCount(3, 1, 0));
  }
}