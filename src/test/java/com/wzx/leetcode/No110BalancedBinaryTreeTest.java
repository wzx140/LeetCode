package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No110BalancedBinaryTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4));

  @Test
  public void isBalanced() {
    No110BalancedBinaryTree solution = new No110BalancedBinaryTree();
    assertTrue(solution.isBalanced(tree1));
    assertFalse(solution.isBalanced(tree2));
    assertTrue(solution.isBalanced(null));
  }
}