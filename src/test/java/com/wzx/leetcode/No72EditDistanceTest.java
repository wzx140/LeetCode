package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No72EditDistanceTest {

  private final String word11 = "horse";
  private final String word12 = "ros";
  private final String word21 = "intention";
  private final String word22 = "execution";

  @Test
  public void minDistance1() {
    No72EditDistance solution = new No72EditDistance();
    assertEquals(3, solution.minDistance1(word11, word12));
    assertEquals(5, solution.minDistance1(word21, word22));
  }

  @Test
  public void minDistance2() {
    No72EditDistance solution = new No72EditDistance();
    assertEquals(3, solution.minDistance2(word11, word12));
    assertEquals(5, solution.minDistance2(word21, word22));
  }
}