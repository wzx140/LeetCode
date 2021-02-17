package com.wzx.sword;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class No17PrintMaximumNDigitsTest {

  @Test
  public void printNumbers1() {
    No17PrintMaximumNDigits solution = new No17PrintMaximumNDigits();
    int[] res = solution.printNumbers1(2);
    assertArrayEquals(IntStream.range(1, 100).toArray(), res);
  }
}