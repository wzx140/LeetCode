package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class No32PrintTheBinaryTreeFromTopToBottom3Test {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
  private final List<List<Integer>> res1 = Arrays.asList(
          Collections.singletonList(3),
          Arrays.asList(20, 9),
          Arrays.asList(15, 7)
  );

  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8));
  private final List<List<Integer>> res2 = Arrays.asList(
          Collections.singletonList(0),
          Arrays.asList(4, 2),
          Arrays.asList(1, 3, -1),
          Arrays.asList(8, 6, 1, 5)
  );

  @Test
  public void levelOrder1() {
    No32PrintTheBinaryTreeFromTopToBottom3 solution = new No32PrintTheBinaryTreeFromTopToBottom3();
    assertEquals(res1, solution.levelOrder1(tree1));
    assertEquals(res2, solution.levelOrder1(tree2));
  }

  @Test
  public void levelOrder2() {
    No32PrintTheBinaryTreeFromTopToBottom3 solution = new No32PrintTheBinaryTreeFromTopToBottom3();
    assertEquals(res1, solution.levelOrder2(tree1));
    assertEquals(res2, solution.levelOrder2(tree2));
  }
}