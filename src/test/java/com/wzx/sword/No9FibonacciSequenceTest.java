package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No9FibonacciSequenceTest {

  @Test
  public void fibonacci1() {
    assertEquals(2, No9FibonacciSequence.Fibonacci1(3));
    assertEquals(5, No9FibonacciSequence.Fibonacci1(5));
    assertEquals(0, No9FibonacciSequence.Fibonacci1(0));
    assertEquals(1, No9FibonacciSequence.Fibonacci1(1));
    assertEquals(1, No9FibonacciSequence.Fibonacci1(2));
    assertEquals(55, No9FibonacciSequence.Fibonacci1(10));
  }

  @Test
  public void fibonacci2() {
    assertEquals(2, No9FibonacciSequence.Fibonacci2(3));
    assertEquals(5, No9FibonacciSequence.Fibonacci2(5));
    assertEquals(0, No9FibonacciSequence.Fibonacci2(0));
    assertEquals(1, No9FibonacciSequence.Fibonacci2(1));
    assertEquals(1, No9FibonacciSequence.Fibonacci2(2));
    assertEquals(55, No9FibonacciSequence.Fibonacci2(10));
  }
}