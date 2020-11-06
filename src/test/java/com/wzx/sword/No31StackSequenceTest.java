package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No31StackSequenceTest {

  private final int[] pushArray1 = new int[]{1, 2, 3, 4, 5};
  private final int[] popArray1 = new int[]{4, 5, 3, 2, 1};
  private final int[] pushArray2 = new int[]{1, 2, 3, 4, 5};
  private final int[] popArray2 = new int[]{4, 3, 5, 1, 2};

  @Test
  public void validateStackSequences() {
    No31StackSequence solution = new No31StackSequence();
    assertTrue(solution.validateStackSequences(pushArray1, popArray1));
    assertFalse(solution.validateStackSequences(pushArray2, popArray2));
  }

}