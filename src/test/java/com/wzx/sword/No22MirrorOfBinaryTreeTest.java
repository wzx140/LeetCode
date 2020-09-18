package com.wzx.sword;

import com.wzx.entity.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class No22MirrorOfBinaryTreeTest {

  private TreeNode tree = null;
  private final TreeNode target = TreeNode.buildTree(Arrays.asList(8, 10, 6, 11, 9, 7, 5));

  @Before
  public void setUp() {
    tree = TreeNode.buildTree(Arrays.asList(8, 6, 10, 5, 7, 9, 11));
  }

  @Test
  public void mirror1() {
    No22MirrorOfBinaryTree.mirror1(tree);
    assertTrue(TreeNode.treeEquals(target, tree));
  }

  @Test
  public void mirror2() {
    No22MirrorOfBinaryTree.mirror2(tree);
    assertTrue(TreeNode.treeEquals(target, tree));
  }
}