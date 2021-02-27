package com.wzx.sword;

import com.wzx.sword.No8BinaryTreeNextNode.TreeLinkNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class No8BinaryTreeNextNodeTest {

  private TreeLinkNode tree1 = null;
  private TreeLinkNode tree2 = null;
  private TreeLinkNode tree3 = null;
  private TreeLinkNode tree4 = null;
  private TreeLinkNode tree5 = null;

  @Before
  public void setUp() {
    tree1 = new TreeLinkNode(0);
    tree1.left = new TreeLinkNode(1);
    tree1.left.next = tree1;
    tree1.right = new TreeLinkNode(2);
    tree1.right.next = tree1;
    tree1.left.left = new TreeLinkNode(3);
    tree1.left.left.next = tree1.left;
    tree1.left.right = new TreeLinkNode(4);
    tree1.left.right.next = tree1.left;
    tree1.right.left = new TreeLinkNode(5);
    tree1.right.left.next = tree1.right;
    tree1.right.right = new TreeLinkNode(6);
    tree1.right.right.next = tree1.right;

    tree2 = new TreeLinkNode(0);
    tree2.left = new TreeLinkNode(1);
    tree2.left.next = tree2;
    tree2.right = new TreeLinkNode(2);
    tree2.right.next = tree2;
    tree2.left.right = new TreeLinkNode(4);
    tree2.left.right.next = tree2.left;
    tree2.right.left = new TreeLinkNode(5);
    tree2.right.left.next = tree2.right;

    tree3 = new TreeLinkNode(0);
    tree3.left = new TreeLinkNode(1);
    tree3.left.next = tree3;
    tree3.left.left = new TreeLinkNode(3);
    tree3.left.left.next = tree3.left;

    tree4 = new TreeLinkNode(0);
    tree4.right = new TreeLinkNode(2);
    tree4.right.next = tree4;
    tree4.right.right = new TreeLinkNode(6);
    tree4.right.right.next = tree4.right;

    tree5 = new TreeLinkNode(8);
    tree5.left = new TreeLinkNode(6);
    tree5.left.next = tree5;
    tree5.right = new TreeLinkNode(10);
    tree5.right.next = tree5;
    tree5.left.left = new TreeLinkNode(5);
    tree5.left.left.next = tree5.left;
    tree5.left.right = new TreeLinkNode(7);
    tree5.left.right.next = tree5.left;
    tree5.right.left = new TreeLinkNode(9);
    tree5.right.left.next = tree5.right;
    tree5.right.right = new TreeLinkNode(11);
    tree5.right.right.next = tree5.right;
  }

  @Test
  public void getNext() {
    No8BinaryTreeNextNode solution = new No8BinaryTreeNextNode();
    assertEquals(tree1.left.right, solution.GetNext(tree1.left));
    assertEquals(tree1, solution.GetNext(tree1.left.right));
    assertEquals(tree2, solution.GetNext(tree2.left.right));
    assertEquals(tree2.right, solution.GetNext(tree2.right.left));
    assertEquals(tree3.left, solution.GetNext(tree3.left.left));
    assertEquals(tree4.right.right, solution.GetNext(tree4.right));
    assertNull(solution.GetNext(tree5.right.right));
  }
}