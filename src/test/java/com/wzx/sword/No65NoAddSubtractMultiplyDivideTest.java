package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No65NoAddSubtractMultiplyDivideTest {

  @Test
  public void add() {
    No65NoAddSubtractMultiplyDivide solution = new No65NoAddSubtractMultiplyDivide();
    assertEquals(2, solution.add(1, 1));
  }
}