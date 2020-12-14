package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class No701InsertIntoABinarySearchTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(4, 2, 7, 1, 3));
  private final TreeNode res1 = TreeNode.buildTree(Arrays.asList(4, 2, 7, 1, 3, 5));

  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(40, 20, 60, 10, 30, 50, 70));
  private final TreeNode res2 = TreeNode.buildTree(Arrays.asList(40, 20, 60, 10, 30, 50, 70, null, null, 25));

  private final TreeNode tree3 = TreeNode.buildTree(Arrays.asList(4, 2, 7, 1, 3, null, null, null, null, null, null));
  private final TreeNode res3 = TreeNode.buildTree(Arrays.asList(4, 2, 7, 1, 3, 5));

  @Test
  public void insertIntoBST() {
    No701InsertIntoABinarySearchTree solution = new No701InsertIntoABinarySearchTree();
    assertEquals(res1, solution.insertIntoBST(tree1, 5));
    assertEquals(res2, solution.insertIntoBST(tree2, 25));
    assertEquals(res3, solution.insertIntoBST(tree3, 5));
  }
}