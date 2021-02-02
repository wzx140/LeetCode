package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No60NumberOfNDiceTest {

  private final double[] res1 = {0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667};
  private final double[] res2 = {0.02778, 0.05556, 0.08333, 0.11111, 0.13889, 0.16667, 0.13889, 0.11111, 0.08333, 0.05556, 0.02778};

  @Test
  public void dicesProbability1() {
    No60NumberOfNDice solution = new No60NumberOfNDice();
    assertArrayEquals(res1, solution.dicesProbability1(1), 0.00001);
    assertArrayEquals(res2, solution.dicesProbability1(2), 0.00001);
  }

  @Test
  public void dicesProbability2() {
    No60NumberOfNDice solution = new No60NumberOfNDice();
    assertArrayEquals(res1, solution.dicesProbability2(1), 0.00001);
    assertArrayEquals(res2, solution.dicesProbability2(2), 0.00001);
  }

  @Test
  public void dicesProbability3() {
    No60NumberOfNDice solution = new No60NumberOfNDice();
    assertArrayEquals(res1, solution.dicesProbability3(1), 0.00001);
    assertArrayEquals(res2, solution.dicesProbability3(2), 0.00001);
  }
}