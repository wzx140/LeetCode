package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No124BinaryTreeMaximumPathSumTest {

  private final TreeNode root1 = TreeNode.buildTree(Arrays.asList(1, 2, 3));
  private final TreeNode root2 = TreeNode.buildTree(Arrays.asList(-10, 9, 20, null, null, 15, 7));


  @Test
  public void maxPathSum() {
    No124BinaryTreeMaximumPathSum solution = new No124BinaryTreeMaximumPathSum();
    assertEquals(6, solution.maxPathSum(root1));
    assertEquals(42, solution.maxPathSum(root2));
  }
}