package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * @author wzx
 */
public class No701InsertIntoABinarySearchTree {

  /**
   * 递归
   *
   * time: O(h)
   * space: O(h)
   */
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);

    if (root.val > val) root.left = insertIntoBST(root.left, val);
    if (root.val < val) root.right = insertIntoBST(root.right, val);

    return root;
  }
}
