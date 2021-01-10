package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class No102BinaryTreeUtilLevelOrderTraversalTest {

  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
  private final List<List<Integer>> res = Arrays.asList(
          Arrays.asList(3),
          Arrays.asList(9, 20),
          Arrays.asList(15, 7)
  );

  @Test
  public void levelOrder() {
    No102BinaryTreeLevelOrderTraversal solution = new No102BinaryTreeLevelOrderTraversal();
    assertEquals(res, solution.levelOrder(tree));
  }
}