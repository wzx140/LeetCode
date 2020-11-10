package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 *
 * @author wzx
 */
public class No100SameTree {

  /**
   * 递归
   *
   * time: O(n)
   * space: O(h)
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
