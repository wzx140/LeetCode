package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * @author wzx
 */
public class No222CountCompleteTreeNodes {

  /**
   * 迭代, 广搜
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int countNodes1(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList<>();
    if (root == null) return 0;

    int cnt = 1;
    queue.addLast(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.pollLast();
      if (node.left != null) {
        cnt++;
        queue.addFirst(node.left);
      }
      if (node.right != null) {
        cnt++;
        queue.addFirst(node.right);
      }
    }

    return cnt;
  }

  /**
   * 递归，暴力解法
   * <p>
   * time: O(n)
   * space: O(h)
   */
  public int countNodes2(TreeNode root) {
    if (root == null) return 0;

    return countNodes2(root.left) + countNodes2(root.right) + 1;
  }

  /**
   * 一棵完全二叉树的两棵子树，至少有一棵是满二叉树
   * <p>
   * time: O(logn*logn)
   * space: O(n)
   */
  public int countNodes3(TreeNode root) {
    if (root == null) return 0;

    // 最左边路径的长度
    int leftHeight = 0;
    TreeNode leftTree = root;
    while (leftTree != null) {
      leftHeight++;
      leftTree = leftTree.left;
    }
    // 最右边路径的长度
    int rightHeight = 0;
    TreeNode rightTree = root;
    while (rightTree != null) {
      rightHeight++;
      rightTree = rightTree.right;
    }
    if (rightHeight == leftHeight) {
      // 满二叉树
      return (int) Math.pow(2, leftHeight) - 1;
    }

    // 不为满二叉树, 按普通二叉树计算
    return countNodes3(root.left) + countNodes3(root.right) + 1;
  }
}
