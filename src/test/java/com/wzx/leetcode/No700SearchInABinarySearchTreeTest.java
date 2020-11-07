package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No700SearchInABinarySearchTreeTest {

  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(4, 2, 7, 1, 3, null, null));

  @Test
  public void searchBST() {
    No700SearchInABinarySearchTree solution = new No700SearchInABinarySearchTree();
    assertEquals(tree.left, solution.searchBST(tree, 2));
  }
}