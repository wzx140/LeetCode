package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No9FibonacciSequenceTest {

  @Test
  public void fibonacci1() {
    assertEquals(2, No9FibonacciSequence.fibonacci1(3));
    assertEquals(5, No9FibonacciSequence.fibonacci1(5));
    assertEquals(0, No9FibonacciSequence.fibonacci1(0));
    assertEquals(1, No9FibonacciSequence.fibonacci1(1));
    assertEquals(1, No9FibonacciSequence.fibonacci1(2));
    assertEquals(55, No9FibonacciSequence.fibonacci1(10));
  }

  @Test
  public void fibonacci2() {
    assertEquals(2, No9FibonacciSequence.fibonacci2(3));
    assertEquals(5, No9FibonacciSequence.fibonacci2(5));
    assertEquals(0, No9FibonacciSequence.fibonacci2(0));
    assertEquals(1, No9FibonacciSequence.fibonacci2(1));
    assertEquals(1, No9FibonacciSequence.fibonacci2(2));
    assertEquals(55, No9FibonacciSequence.fibonacci2(10));
  }
}