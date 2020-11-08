package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class No450DeleteNodeInABSTTest {

  private final TreeNode tree1 = TreeNode.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, 7));
  private final TreeNode res1 = TreeNode.buildTree(Arrays.asList(5, 4, 6, 2, null, null, 7));

  private final TreeNode tree2 = TreeNode.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, 7));
  private final TreeNode res2 = TreeNode.buildTree(Arrays.asList(5, 3, 6, 2, 4, null, 7));

  @Test
  public void deleteNode() {
    No450DeleteNodeInABST solution = new No450DeleteNodeInABST();
    assertTrue(TreeNode.treeEquals(res1, solution.deleteNode(tree1, 3)));
    assertTrue(TreeNode.treeEquals(res2, solution.deleteNode(tree2, 0)));
    assertNull(solution.deleteNode(null, 0));
  }
}