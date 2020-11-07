package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * @author wzx
 */
public class No98ValidateBinarySearchTree {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public boolean isValidBST(TreeNode root) {
    return recursion(root, null, null);
  }

  /**
   * @param root 当前子树根结点
   * @param max  当前子树的最大值
   * @param min  当前子树的最小值
   * @return 是否是合法BST
   */
  private boolean recursion(TreeNode root, Integer max, Integer min) {
    if (root == null) return true;

    if (max != null && root.val > max) return false;
    if (min != null && root.val < min) return false;

    return recursion(root.left, root.val, min) && recursion(root.right, max, root.val);
  }
}
