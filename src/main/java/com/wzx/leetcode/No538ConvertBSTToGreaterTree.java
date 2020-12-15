package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * @author wzx
 */
public class No538ConvertBSTToGreaterTree {

  private int sum = 0;

  /**
   * BST的反中序遍历+全局变量
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public TreeNode convertBST(TreeNode root) {
    sum = 0;
    helper(root);
    return root;
  }

  private void helper(TreeNode root) {
    if (root == null) return;
    helper(root.right);
    sum += root.val;
    root.val = sum;
    helper(root.left);
  }
}
