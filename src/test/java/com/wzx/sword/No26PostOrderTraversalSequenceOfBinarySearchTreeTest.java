package com.wzx.sword;

import org.junit.Test;

import static org.junit.Assert.*;

public class No26PostOrderTraversalSequenceOfBinarySearchTreeTest {

  private final int[] array1 = new int[]{5, 7, 6, 9, 11, 10, 8};
  private final int[] array2 = new int[]{7, 4, 6, 5};
  private final int[] array3 = new int[]{4, 6, 7, 5};

  @Test
  public void verifySequenceOfBST() {
    assertTrue(No26PostOrderTraversalSequenceOfBinarySearchTree.VerifySequenceOfBST(array1));
    assertFalse(No26PostOrderTraversalSequenceOfBinarySearchTree.VerifySequenceOfBST(array2));
    assertTrue(No26PostOrderTraversalSequenceOfBinarySearchTree.VerifySequenceOfBST(array3));
  }
}