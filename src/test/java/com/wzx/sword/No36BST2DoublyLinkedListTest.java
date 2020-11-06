package com.wzx.sword;

import com.wzx.entity.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No36BST2DoublyLinkedListTest {

  private TreeNode tree = null;

  @Before
  public void setUp() {
    tree = TreeNode.buildTree(Arrays.asList(3, 2, 4, 1, null, null, 5));
  }

  @Test
  public void convert() {
    No36BST2DoublyLinkedList solution = new No36BST2DoublyLinkedList();
    TreeNode list = solution.treeToDoublyList(tree);
    assertEquals(1, list.val);
    assertEquals(5, list.left.val);
    assertEquals(4, list.left.left.val);
    assertEquals(3, list.left.left.left.val);
    assertEquals(2, list.left.left.left.left.val);
    assertEquals(1, list.left.left.left.left.left.val);

    assertEquals(2, list.right.val);
    assertEquals(3, list.right.right.val);
    assertEquals(4, list.right.right.right.val);
    assertEquals(5, list.right.right.right.right.val);
    assertEquals(1, list.right.right.right.right.right.val);
  }
}