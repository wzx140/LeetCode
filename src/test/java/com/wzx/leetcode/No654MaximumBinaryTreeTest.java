package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No654MaximumBinaryTreeTest {

  private final int[] nums = new int[]{3, 2, 1, 6, 0, 5};
  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(6, 3, 5, null, 2, 0, null, null, 1));

  @Test
  public void constructMaximumBinaryTree() {
    No654MaximumBinaryTree solution = new No654MaximumBinaryTree();
    assertEquals(tree, solution.constructMaximumBinaryTree(nums));
  }
}