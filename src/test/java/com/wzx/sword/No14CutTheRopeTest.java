package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No14CutTheRopeTest {

  @Test
  public void cutRope1() {
    No14CutTheRope solution = new No14CutTheRope();
    assertEquals(1, solution.cuttingRope1(2));
    assertEquals(36, solution.cuttingRope1(10));
  }

  @Test
  public void cutRope2() {
    No14CutTheRope solution = new No14CutTheRope();
    assertEquals(1, solution.cuttingRope2(2));
    assertEquals(36, solution.cuttingRope2(10));
  }
}