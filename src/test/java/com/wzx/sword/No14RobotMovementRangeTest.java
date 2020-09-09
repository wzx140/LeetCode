package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No14RobotMovementRangeTest {

  @Test
  public void movingCount() {
    assertEquals(21, No14RobotMovementRange.movingCount(5, 15, 15));
  }
}