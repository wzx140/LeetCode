package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No12MatrixCoverageTest {

  @Test
  public void rectCover() {
    assertEquals(0, No12MatrixCoverage.rectCover(0));
    assertEquals(1, No12MatrixCoverage.rectCover(1));
    assertEquals(2, No12MatrixCoverage.rectCover(2));
    assertEquals(3, No12MatrixCoverage.rectCover(3));
    assertEquals(5, No12MatrixCoverage.rectCover(4));
  }
}