package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No15NumOfOneInBinaryTest {

  @Test
  public void hammingWeight1() {
    No15NumOfOneInBinary solution = new No15NumOfOneInBinary();
    assertEquals(2, solution.hammingWeight1(9));
    assertEquals(32, solution.hammingWeight1(-1));
  }

  @Test
  public void hammingWeight2() {
    No15NumOfOneInBinary solution = new No15NumOfOneInBinary();
    assertEquals(2, solution.hammingWeight2(9));
    assertEquals(32, solution.hammingWeight2(-1));
  }
}