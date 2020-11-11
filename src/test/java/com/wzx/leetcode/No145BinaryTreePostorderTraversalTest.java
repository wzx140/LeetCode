package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class No145BinaryTreePostorderTraversalTest {
  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(1, null, 2, 3));
  private final List<Integer> res1 = Arrays.asList(3, 2, 1);
  private final TreeNode tree2 = TreeNode.buildTree(Collections.singletonList(1));
  private final List<Integer> res2 = Collections.singletonList(1);
  private final TreeNode tree3 = TreeNode.buildTree(Arrays.asList(1, 2));
  private final List<Integer> res3 = Arrays.asList(2, 1);
  private final TreeNode tree4 = TreeNode.buildTree(Arrays.asList(1, null, 2));
  private final List<Integer> res4 = Arrays.asList(2, 1);

  @Test
  public void postorderTraversal1() {
    No145BinaryTreePostorderTraversal solution = new No145BinaryTreePostorderTraversal();
    assertEquals(res1, solution.postorderTraversal1(tree1));
    assertEquals(res2, solution.postorderTraversal1(tree2));
    assertEquals(res3, solution.postorderTraversal1(tree3));
    assertEquals(res4, solution.postorderTraversal1(tree4));
    assertTrue(solution.postorderTraversal1(null).isEmpty());
  }

  @Test
  public void postorderTraversal2() {
    No145BinaryTreePostorderTraversal solution = new No145BinaryTreePostorderTraversal();
    assertEquals(res1, solution.postorderTraversal2(tree1));
    assertEquals(res2, solution.postorderTraversal2(tree2));
    assertEquals(res3, solution.postorderTraversal2(tree3));
    assertEquals(res4, solution.postorderTraversal2(tree4));
    assertTrue(solution.postorderTraversal2(null).isEmpty());
  }
}