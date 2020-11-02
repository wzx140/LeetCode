package com.wzx.sword;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No68NearestCommonAncestorOfBinaryTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
  private final TreeNode p1 = tree1.left;
  private final TreeNode q1 = tree1.right;
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
  private final TreeNode p2 = tree2.left;
  private final TreeNode q2 = p2.right.right;

  @Test
  public void lowestCommonAncestor() {
    No68NearestCommonAncestorOfBinaryTree solution = new No68NearestCommonAncestorOfBinaryTree();
    assertEquals(3, solution.lowestCommonAncestor(tree1, p1, q1).val);
    assertEquals(5, solution.lowestCommonAncestor(tree2, p2, q2).val);
  }

}