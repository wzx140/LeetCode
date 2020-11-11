package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class No144BinaryTreePreorderTraversalTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(1, null, 2, 3));
  private final List<Integer> res1 = Arrays.asList(1, 2, 3);
  private final TreeNode tree2 = TreeNode.buildTree(Collections.singletonList(1));
  private final List<Integer> res2 = Collections.singletonList(1);
  private final TreeNode tree3 = TreeNode.buildTree(Arrays.asList(1, 2));
  private final List<Integer> res3 = Arrays.asList(1, 2);
  private final TreeNode tree4 = TreeNode.buildTree(Arrays.asList(1, null, 2));
  private final List<Integer> res4 = Arrays.asList(1, 2);

  @Test
  public void preorderTraversal1() {
    No144BinaryTreePreorderTraversal solution = new No144BinaryTreePreorderTraversal();
    assertEquals(res1, solution.preorderTraversal1(tree1));
    assertEquals(res2, solution.preorderTraversal1(tree2));
    assertEquals(res3, solution.preorderTraversal1(tree3));
    assertEquals(res4, solution.preorderTraversal1(tree4));
    assertTrue(solution.preorderTraversal1(null).isEmpty());
  }

  @Test
  public void preorderTraversal2() {
    No144BinaryTreePreorderTraversal solution = new No144BinaryTreePreorderTraversal();
    assertEquals(res1, solution.preorderTraversal2(tree1));
    assertEquals(res2, solution.preorderTraversal2(tree2));
    assertEquals(res3, solution.preorderTraversal2(tree3));
    assertEquals(res4, solution.preorderTraversal2(tree4));
    assertTrue(solution.preorderTraversal2(null).isEmpty());
  }
}