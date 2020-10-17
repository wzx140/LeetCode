package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No104MaximumDepthOfBinaryTreeTest {

  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));

  @Test
  public void maxDepth() {
    No104MaximumDepthOfBinaryTree solution = new No104MaximumDepthOfBinaryTree();
    assertEquals(3, solution.maxDepth(tree));
  }
}