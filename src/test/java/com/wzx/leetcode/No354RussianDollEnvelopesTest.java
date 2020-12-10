package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class No354RussianDollEnvelopesTest {

  private final int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};

  @Test
  public void maxEnvelopes() {
    No354RussianDollEnvelopes solution = new No354RussianDollEnvelopes();
    assertEquals(3, solution.maxEnvelopes(envelopes));
  }
}