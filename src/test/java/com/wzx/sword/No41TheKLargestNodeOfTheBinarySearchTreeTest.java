package com.wzx.sword;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No41TheKLargestNodeOfTheBinarySearchTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 1, 4, null, 2));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, null, 1));

  @Test
  public void kthLargest() {
    No41TheKLargestNodeOfTheBinarySearchTree solution = new No41TheKLargestNodeOfTheBinarySearchTree();
    assertEquals(4, solution.kthLargest(tree1, 1));
    assertEquals(4, solution.kthLargest(tree2, 3));
  }
}