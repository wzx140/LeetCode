package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No60NumberOfNDiceTest {

  private final double[] res1 = {0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667};
  private final double[] res2 = {0.02778, 0.05556, 0.08333, 0.11111, 0.13889, 0.16667, 0.13889, 0.11111, 0.08333, 0.05556, 0.02778};

  @Test
  public void twoSum1() {
    No60NumberOfNDice solution = new No60NumberOfNDice();
    assertArrayEquals(res1, solution.twoSum1(1), 0.00001);
    assertArrayEquals(res2, solution.twoSum1(2), 0.00001);
  }

  @Test
  public void twoSum2() {
    No60NumberOfNDice solution = new No60NumberOfNDice();
    assertArrayEquals(res1, solution.twoSum2(1), 0.00001);
    assertArrayEquals(res2, solution.twoSum2(2), 0.00001);
  }

  @Test
  public void twoSum3() {
    No60NumberOfNDice solution = new No60NumberOfNDice();
    assertArrayEquals(res1, solution.twoSum3(1), 0.00001);
    assertArrayEquals(res2, solution.twoSum3(2), 0.00001);
  }
}