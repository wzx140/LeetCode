package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No111MinimumDepthOfBinaryTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(2, null, 3, null, 4, null, 5, null, 6));

  @Test
  public void minDepth() {
    No111MinimumDepthOfBinaryTree solution = new No111MinimumDepthOfBinaryTree();
    assertEquals(2, solution.minDepth(tree1));
    assertEquals(5, solution.minDepth(tree2));
  }
}