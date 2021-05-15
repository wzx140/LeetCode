package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No543DiameterOfBinaryTreeTest {

  private final TreeNode root = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, 5));

  @Test
  public void diameterOfBinaryTree() {
    No543DiameterOfBinaryTree solution = new No543DiameterOfBinaryTree();
    assertEquals(solution.diameterOfBinaryTree(root), 3);
  }
}