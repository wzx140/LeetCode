package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class No94BinaryTreeInorderTraversalTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(1, null, 2, 3));
  private final List<Integer> res1 = Arrays.asList(1, 3, 2);
  private final TreeNode tree2 = TreeNode.buildTree(Collections.singletonList(1));
  private final List<Integer> res2 = Collections.singletonList(1);
  private final TreeNode tree3 = TreeNode.buildTree(Arrays.asList(1, 2));
  private final List<Integer> res3 = Arrays.asList(2, 1);
  private final TreeNode tree4 = TreeNode.buildTree(Arrays.asList(1, null, 2));
  private final List<Integer> res4 = Arrays.asList(1, 2);

  @Test
  public void inorderTraversal1() {
    No94BinaryTreeInorderTraversal solution = new No94BinaryTreeInorderTraversal();
    assertEquals(res1, solution.inorderTraversal1(tree1));
    assertEquals(res2, solution.inorderTraversal1(tree2));
    assertEquals(res3, solution.inorderTraversal1(tree3));
    assertEquals(res4, solution.inorderTraversal1(tree4));
    assertTrue(solution.inorderTraversal1(null).isEmpty());
  }

  @Test
  public void inorderTraversal2() {
    No94BinaryTreeInorderTraversal solution = new No94BinaryTreeInorderTraversal();
    assertEquals(res1, solution.inorderTraversal2(tree1));
    assertEquals(res2, solution.inorderTraversal2(tree2));
    assertEquals(res3, solution.inorderTraversal2(tree3));
    assertEquals(res4, solution.inorderTraversal2(tree4));
    assertTrue(solution.inorderTraversal2(null).isEmpty());
  }

  @Test
  public void inorderTraversal3() {
    No94BinaryTreeInorderTraversal solution = new No94BinaryTreeInorderTraversal();
    assertEquals(res1, solution.inorderTraversal3(tree1));
    assertEquals(res2, solution.inorderTraversal3(tree2));
    assertEquals(res3, solution.inorderTraversal3(tree3));
    assertEquals(res4, solution.inorderTraversal3(tree4));
    assertTrue(solution.inorderTraversal3(null).isEmpty());
  }
}