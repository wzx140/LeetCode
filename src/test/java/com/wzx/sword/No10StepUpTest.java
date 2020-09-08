package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No10StepUpTest {

  @Test
  public void jumpFloor1() {
    assertEquals(1, No10StepUp.jumpFloor1(0));
    assertEquals(1, No10StepUp.jumpFloor1(1));
    assertEquals(2, No10StepUp.jumpFloor1(2));
    assertEquals(4, No10StepUp.jumpFloor1(3));
  }

  @Test
  public void jumpFloor2() {
    assertEquals(1, No10StepUp.jumpFloor2(0));
    assertEquals(1, No10StepUp.jumpFloor2(1));
    assertEquals(2, No10StepUp.jumpFloor2(2));
    assertEquals(4, No10StepUp.jumpFloor2(3));
  }

  @Test
  public void jumpFloor3() {
    assertEquals(1, No10StepUp.jumpFloor3(0));
    assertEquals(1, No10StepUp.jumpFloor3(1));
    assertEquals(2, No10StepUp.jumpFloor3(2));
    assertEquals(4, No10StepUp.jumpFloor3(3));
  }
}