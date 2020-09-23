package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No106ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

  private final int[] inorder = { 9,3,15,20,7 };
  private final int[] postorder = { 9,15,7,20,3 };
  private final TreeNode tree = TreeNode.buildTree(Arrays.asList(3,9,20,null,null,15,7));

  @Test
  public void buildTree() {
    No106ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new No106ConstructBinaryTreeFromInorderAndPostorderTraversal();
    assertTrue(TreeNode.treeEquals(tree, solution.buildTree(inorder, postorder)));
  }
}