package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No25StackSequenceTest {

  private final int[] pushArray1 = new int[]{1, 2, 3, 4, 5};
  private final int[] popArray1 = new int[]{4, 5, 3, 2, 1};
  private final int[] pushArray2 = new int[]{1, 2, 3, 4, 5};
  private final int[] popArray2 = new int[]{4, 3, 5, 1, 2};

  @Test
  public void isPopOrder() {
    assertTrue(No25StackSequence.IsPopOrder(pushArray1, popArray1));
    assertFalse(No25StackSequence.IsPopOrder(pushArray2, popArray2));
  }

}