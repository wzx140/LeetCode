package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No64Solve1tonTest {

  @Test
  public void sumNums1() {
    No64Solve1ton solution = new No64Solve1ton();
    assertEquals(6, solution.sumNums1(3));
    assertEquals(45, solution.sumNums1(9));
  }

  @Test
  public void sumNums2() {
    No64Solve1ton solution = new No64Solve1ton();
    assertEquals(6, solution.sumNums2(3));
    assertEquals(45, solution.sumNums2(9));
  }
}