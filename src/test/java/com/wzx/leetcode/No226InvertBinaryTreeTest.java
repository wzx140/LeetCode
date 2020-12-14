package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No226InvertBinaryTreeTest {

  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(4, 2, 7, 1, 3, 6, 9));
  private final TreeNode res = TreeNode.buildTree(Arrays.asList(4, 7, 2, 9, 6, 3, 1));

  @Test
  public void invertTree() {
    No226InvertBinaryTree solution = new No226InvertBinaryTree();
    assertEquals(res, solution.invertTree(tree));
  }
}