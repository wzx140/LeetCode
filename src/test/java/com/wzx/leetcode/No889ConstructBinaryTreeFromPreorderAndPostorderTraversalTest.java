package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No889ConstructBinaryTreeFromPreorderAndPostorderTraversalTest {

  private final int[] preorder = {1, 2, 4, 5, 3, 6, 7};
  private final int[] postorder = {4, 5, 2, 6, 7, 3, 1};
  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

  @Test
  public void constructFromPrePost() {
    No889ConstructBinaryTreeFromPreorderAndPostorderTraversal solution = new No889ConstructBinaryTreeFromPreorderAndPostorderTraversal();
    assertEquals(tree, solution.constructFromPrePost(preorder, postorder));
  }
}