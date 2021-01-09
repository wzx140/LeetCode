package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">https://leetcode.com/problems/populating-next-right-pointers-in-each-node/</a>
 * @author wzx
 */
public class No116PopulatingNextRightPointersInEachNode {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public Node connect(Node root) {
    if (root == null) return null;
    recursion(root.left, root.right);
    return root;
  }

  private void recursion(Node left, Node right) {
    // 注意是完美二叉树
    if (left == null || right == null) return;

    left.next = right;
    recursion(left.left, left.right);
    recursion(left.right, right.left);
    recursion(right.left, right.right);
  }

  public static class Node {
    int val;
    Node left;
    Node right;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }
}
