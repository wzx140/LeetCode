package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class No105ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

  private final int[] preorder = {3, 9, 20, 15, 7};
  private final int[] inorder = {9, 3, 15, 20, 7};
  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));

  @Test
  public void buildTree() {
    No105ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new No105ConstructBinaryTreeFromPreorderAndInorderTraversal();
    assertTrue(TreeNode.treeEquals(tree, solution.buildTree(preorder, inorder)));
  }
}