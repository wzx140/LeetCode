package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class No114FlattenBinaryTreeToLinkedListTest {

  private TreeNode source = null;
  private final TreeNode flatten = TreeNode.buildTree(Arrays.asList(1, null, 2, null, 3, null, 4, null, 5, null, 6));

  @Before
  public void setUp() {
    source = TreeNode.buildTree(Arrays.asList(1, 2, 5, 3, 4, null, 6));
  }

  @Test
  public void flatten1() {
    No114FlattenBinaryTreeToLinkedList solution = new No114FlattenBinaryTreeToLinkedList();
    solution.flatten1(source);
    Assert.assertTrue(TreeNode.treeEquals(flatten, source));
  }

  @Test
  public void flatten2() {
    No114FlattenBinaryTreeToLinkedList solution = new No114FlattenBinaryTreeToLinkedList();
    solution.flatten2(source);
    Assert.assertTrue(TreeNode.treeEquals(flatten, source));
  }
}