package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No33PostOrderTraversalSequenceOfBinarySearchTreeTest {

  private final int[] array1 = new int[]{5, 7, 6, 9, 11, 10, 8};
  private final int[] array2 = new int[]{7, 4, 6, 5};
  private final int[] array3 = new int[]{4, 6, 7, 5};

  @Test
  public void verifySequenceOfBST() {
    No33PostOrderTraversalSequenceOfBinarySearchTree solution = new No33PostOrderTraversalSequenceOfBinarySearchTree();
    assertTrue(solution.verifyPostorder(array1));
    assertFalse(solution.verifyPostorder(array2));
    assertTrue(solution.verifyPostorder(array3));
  }
}