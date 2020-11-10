package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * @author wzx
 */
public class No110BalancedBinaryTree {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(h)
   */
  public boolean isBalanced(TreeNode root) {
    return recursion(root) != -1;
  }

  /**
   * 参考 104. Maximum Depth of Binary Tree 题，求树最大高度
   * 在计算高度的过程中，比较左右子树的高度。-1表示检测出不平衡的子树
   */
  private int recursion(TreeNode node) {
    if (node == null) return 0;

    int leftHeight = recursion(node.left);
    if (leftHeight == -1) return -1;
    int rightHeight = recursion(node.right);
    if (rightHeight == -1) return -1;

    if (Math.abs(leftHeight - rightHeight) > 1) return -1;
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
