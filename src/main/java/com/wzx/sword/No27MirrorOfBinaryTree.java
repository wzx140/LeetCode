package com.wzx.sword;

import com.wzx.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * @author wzx
 */
public class No27MirrorOfBinaryTree {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n) 树高最坏为n
   */
  public TreeNode mirrorTree1(TreeNode root) {
    if (root == null) return null;

    TreeNode tmp = root.left;
    root.left = mirrorTree1(root.right);
    root.right = mirrorTree1(tmp);
    return root;
  }

  /**
   * 迭代
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public TreeNode mirrorTree2(TreeNode root) {
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

    return root;
  }
}
