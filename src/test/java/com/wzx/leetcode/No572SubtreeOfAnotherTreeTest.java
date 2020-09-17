package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No572SubtreeOfAnotherTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 4, 5, 1, 2));
  private final TreeNode subTree1 = TreeNode.buildTree(Arrays.asList(4, 1, 2));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(3, 4, 5, 1, 2, null, null, null, null, 0));
  private final TreeNode subTree2 = TreeNode.buildTree(Arrays.asList(4, 1, 2));

  @Test
  public void isSubtree1() {
    No572SubtreeOfAnotherTree solution = new No572SubtreeOfAnotherTree();
    assertTrue(solution.isSubtree1(tree1, subTree1));
    assertFalse(solution.isSubtree1(tree2, subTree2));
  }

  @Test
  public void isSubtree2() {
    No572SubtreeOfAnotherTree solution = new No572SubtreeOfAnotherTree();
    assertTrue(solution.isSubtree2(tree1, subTree1));
    assertFalse(solution.isSubtree2(tree2, subTree2));
  }
}