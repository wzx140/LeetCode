package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * @author wzx
 */
public class No700SearchInABinarySearchTree {

  /**
   * 递归
   *
   * time: O(h)
   * space: O(h)
   */
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) return null;

    if (root.val > val) {
      return searchBST(root.left, val);
    } else if (root.val < val) {
      return searchBST(root.right, val);
    } else {
      return root;
    }
  }
}
