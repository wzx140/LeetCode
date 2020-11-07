package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class No98ValidateBinarySearchTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(2, 1, 3));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(5, 1, 4, null, null, 3, 6));

  @Test
  public void isValidBST() {
    No98ValidateBinarySearchTree solution = new No98ValidateBinarySearchTree();
    assertTrue(solution.isValidBST(tree1));
    assertFalse(solution.isValidBST(tree2));
  }
}