package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No101SymmetricTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(1, 2, 2, 3, 4, 4, 3));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(1, 2, 2, null, 3, null, 3));

  @Test
  public void isSymmetric() {
    No101SymmetricTree solution = new No101SymmetricTree();
    assertTrue(solution.isSymmetric(tree1));
    assertFalse(solution.isSymmetric(tree2));
  }
}