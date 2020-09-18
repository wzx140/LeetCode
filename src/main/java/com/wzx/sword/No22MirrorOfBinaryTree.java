package com.wzx.sword;

import com.wzx.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011
 *
 * @author wzx
 */
public class No22MirrorOfBinaryTree {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n) 树高最坏为n
   */
  public static void mirror1(TreeNode root) {
    recursion(root);
  }

  private static void recursion(TreeNode node) {
    if (node != null) {
      TreeNode tmp = node.left;
      node.left = node.right;
      node.right = tmp;

      recursion(node.left);
      recursion(node.right);
    }
  }

  /**
   * 迭代
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public static void mirror2(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    if (root != null) queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      TreeNode tmp = node.left;
      node.left = node.right;
      node.right = tmp;

      if (node.left != null) queue.add(node.left);
      if (node.right != null) queue.add(node.right);
    }
  }
}
