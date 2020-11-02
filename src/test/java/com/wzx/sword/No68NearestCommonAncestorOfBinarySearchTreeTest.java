package com.wzx.sword;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No68NearestCommonAncestorOfBinarySearchTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));
  private final TreeNode p1 = tree1.left;
  private final TreeNode q1 = tree1.right;
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));
  private final TreeNode p2 = tree2.left;
  private final TreeNode q2 = p2.right;

  @Test
  public void lowestCommonAncestor1() {
    No68NearestCommonAncestorOfBinarySearchTree solution = new No68NearestCommonAncestorOfBinarySearchTree();
    assertEquals(6, solution.lowestCommonAncestor1(tree1, p1, q1).val);
    assertEquals(2, solution.lowestCommonAncestor1(tree2, p2, q2).val);
  }

  @Test
  public void lowestCommonAncestor2() {
    No68NearestCommonAncestorOfBinarySearchTree solution = new No68NearestCommonAncestorOfBinarySearchTree();
    assertEquals(6, solution.lowestCommonAncestor2(tree1, p1, q1).val);
    assertEquals(2, solution.lowestCommonAncestor2(tree2, p2, q2).val);
  }
}