package com.wzx.sword;

import com.wzx.entity.TreeNode;

public class No41TheKLargestNodeOfTheBinarySearchTree {

  // 当前第i大结点
  private int res = 0;
  // 结点值
  private int i = 0;

  /**
   * 中序遍历的倒序
   * <p>
   * time: O(n)
   * space: O(h)
   */
  public int kthLargest(TreeNode root, int k) {
    i = k;
    recursion(root);
    return res;
  }

  private void recursion(TreeNode root) {
    if (root == null) return;

    recursion(root.right);
    if (--i == 0) {
      res = root.val;
      return;
    }
    recursion(root.left);
  }
}
