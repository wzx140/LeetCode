package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No15CutTheRopeTest {

  @Test
  public void cutRope1() {
    assertEquals(0, No15CutTheRope.cutRope1(0));
    assertEquals(1, No15CutTheRope.cutRope1(1));
    assertEquals(2, No15CutTheRope.cutRope1(2));
    assertEquals(3, No15CutTheRope.cutRope1(3));
    assertEquals(4, No15CutTheRope.cutRope1(4));
    assertEquals(6, No15CutTheRope.cutRope1(5));
    assertEquals(9, No15CutTheRope.cutRope1(6));
    assertEquals(12, No15CutTheRope.cutRope1(7));
    assertEquals(18, No15CutTheRope.cutRope1(8));
  }

  @Test
  public void cutRope2() {
    assertEquals(0, No15CutTheRope.cutRope2(0));
    assertEquals(1, No15CutTheRope.cutRope2(1));
    assertEquals(2, No15CutTheRope.cutRope2(2));
    assertEquals(3, No15CutTheRope.cutRope2(3));
    assertEquals(4, No15CutTheRope.cutRope2(4));
    assertEquals(6, No15CutTheRope.cutRope2(5));
    assertEquals(9, No15CutTheRope.cutRope2(6));
    assertEquals(12, No15CutTheRope.cutRope2(7));
    assertEquals(18, No15CutTheRope.cutRope2(8));
  }
}