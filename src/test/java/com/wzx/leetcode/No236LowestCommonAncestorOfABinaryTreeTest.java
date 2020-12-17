package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No236LowestCommonAncestorOfABinaryTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
  private final TreeNode p1 = tree1.left;
  private final TreeNode q1 = tree1.right;
  private final TreeNode res1 = tree1;
  private final TreeNode p2 = tree1.left;
  private final TreeNode q2 = tree1.left.right.right;
  private final TreeNode res2 = tree1.left;
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(1, 2));
  private final TreeNode p3 = tree2;
  private final TreeNode q3 = tree2.left;
  private final TreeNode res3 = tree2;

  @Test
  public void lowestCommonAncestor() {
    No236LowestCommonAncestorOfABinaryTree solution = new No236LowestCommonAncestorOfABinaryTree();
    assertEquals(res1, solution.lowestCommonAncestor(tree1, p1, q1));
    assertEquals(res2, solution.lowestCommonAncestor(tree1, p2, q2));
    assertEquals(res3, solution.lowestCommonAncestor(tree2, p3, q3));
  }
}