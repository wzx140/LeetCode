package com.wzx.leetcode;

import org.junit.Before;
import org.junit.Test;

import static com.wzx.leetcode.No116PopulatingNextRightPointersInEachNode.Node;
import static org.junit.Assert.assertEquals;

public class No116PopulatingNextRightPointersInEachNodeTest {

  private Node tree = null;

  @Before
  public void setUp() {
    tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);

    tree.left.left = new Node(4);
    tree.left.right = new Node(5);

    tree.right.left = new Node(6);
    tree.right.right = new Node(7);
  }

  @Test
  public void connect() {
    No116PopulatingNextRightPointersInEachNode solution = new No116PopulatingNextRightPointersInEachNode();
    Node res = solution.connect(tree);
    assertEquals(res.left.next, res.right);
    assertEquals(res.left.left.next, res.left.right);
    assertEquals(res.left.right.next, res.right.left);
    assertEquals(res.right.left.next, res.right.right);
  }
}