package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No538ConvertBSTToGreaterTreeTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8));
  private final TreeNode res1 = TreeNode.buildTree(Arrays.asList(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8));
  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(0, null, 1));
  private final TreeNode res2 = TreeNode.buildTree(Arrays.asList(1, null, 1));
  private final TreeNode tree3 = TreeNode.buildTree(Arrays.asList(1, 0, 2));
  private final TreeNode res3 = TreeNode.buildTree(Arrays.asList(3, 3, 2));
  private final TreeNode tree4 = TreeNode.buildTree(Arrays.asList(3, 2, 4, 1));
  private final TreeNode res4 = TreeNode.buildTree(Arrays.asList(7, 9, 4, 10));

  @Test
  public void convertBST() {
    No538ConvertBSTToGreaterTree solution = new No538ConvertBSTToGreaterTree();
    assertEquals(res1, solution.convertBST(tree1));
    assertEquals(res2, solution.convertBST(tree2));
    assertEquals(res3, solution.convertBST(tree3));
    assertEquals(res4, solution.convertBST(tree4));
  }
}