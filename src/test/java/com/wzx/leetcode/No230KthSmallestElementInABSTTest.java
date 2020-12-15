package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No230KthSmallestElementInABSTTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(3, 1, 4, null, 2));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, null, 1));

  @Test
  public void kthSmallest() {
    No230KthSmallestElementInABST solution = new No230KthSmallestElementInABST();
    assertEquals(1, solution.kthSmallest(tree1, 1));
    assertEquals(3, solution.kthSmallest(tree2, 3));
  }
}