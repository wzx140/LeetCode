package com.wzx.sword;

import com.wzx.entity.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class No8BinaryTreeNextNodeTest {
  private TreeNode tree1 = null;
  private TreeNode tree2 = null;
  private TreeNode tree3 = null;
  private TreeNode tree4 = null;

  @Before
  public void setUp() {
    tree1 = new TreeNode(0);
    tree1.left = new TreeNode(1);
    tree1.left.parent = tree1;
    tree1.right = new TreeNode(2);
    tree1.right.parent = tree1;
    tree1.left.left = new TreeNode(3);
    tree1.left.left.parent = tree1.left;
    tree1.left.right = new TreeNode(4);
    tree1.left.right.parent = tree1.left;
    tree1.right.left = new TreeNode(5);
    tree1.right.left.parent = tree1.right;
    tree1.right.right = new TreeNode(6);
    tree1.right.right.parent = tree1.right;

    tree2 = new TreeNode(0);
    tree2.left = new TreeNode(1);
    tree2.left.parent = tree2;
    tree2.right = new TreeNode(2);
    tree2.right.parent = tree2;
    tree2.left.right = new TreeNode(4);
    tree2.left.right.parent = tree2.left;
    tree2.right.left = new TreeNode(5);
    tree2.right.left.parent = tree2.right;

    tree3 = new TreeNode(0);
    tree3.left = new TreeNode(1);
    tree3.left.parent = tree3;
    tree3.left.left = new TreeNode(3);
    tree3.left.left.parent = tree3.left;

    tree4 = new TreeNode(0);
    tree4.right = new TreeNode(2);
    tree4.right.parent = tree4;
    tree4.right.right = new TreeNode(6);
    tree4.right.right.parent = tree4.right;
  }

  @Test
  public void getNext() {
    assertNull(No8BinaryTreeNextNode.GetNext(null));

    assertEquals(tree1.left.right, No8BinaryTreeNextNode.GetNext(tree1.left));
    assertEquals(tree1, No8BinaryTreeNextNode.GetNext(tree1.left.right));

    assertEquals(tree2, No8BinaryTreeNextNode.GetNext(tree2.left.right));
    assertEquals(tree2.right, No8BinaryTreeNextNode.GetNext(tree2.right.left));

    assertEquals(tree3.left, No8BinaryTreeNextNode.GetNext(tree3.left.left));

    assertEquals(tree4.right.right, No8BinaryTreeNextNode.GetNext(tree4.right));
  }
}