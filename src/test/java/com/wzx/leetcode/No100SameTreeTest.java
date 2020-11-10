package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No100SameTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(1, 2, 3));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(1, 2, 3));

  private final TreeNode tree3 = TreeNode.buildTree(Arrays.asList(1, 2));
  private final TreeNode tree4 = TreeNode.buildTree(Arrays.asList(1, null, 2));

  private final TreeNode tree5 = TreeNode.buildTree(Arrays.asList(1, 2, 1));
  private final TreeNode tree6 = TreeNode.buildTree(Arrays.asList(1, 1, 2));

  @Test
  public void isSameTree() {
    No100SameTree solution = new No100SameTree();
    assertTrue(solution.isSameTree(tree1, tree2));
    assertFalse(solution.isSameTree(tree3, tree4));
    assertFalse(solution.isSameTree(tree5, tree6));
  }
}