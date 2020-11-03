package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No10FibonacciSequenceTest {

  @Test
  public void fib1() {
    No10FibonacciSequence solution = new No10FibonacciSequence();
    assertEquals(2, solution.fib1(3));
    assertEquals(5, solution.fib1(5));
    assertEquals(0, solution.fib1(0));
    assertEquals(1, solution.fib1(1));
    assertEquals(1, solution.fib1(2));
    assertEquals(55, solution.fib1(10));
  }

  @Test
  public void fib2() {
    No10FibonacciSequence solution = new No10FibonacciSequence();
    assertEquals(2, solution.fib2(3));
    assertEquals(5, solution.fib2(5));
    assertEquals(0, solution.fib2(0));
    assertEquals(1, solution.fib2(1));
    assertEquals(1, solution.fib2(2));
    assertEquals(55, solution.fib2(10));
  }
}