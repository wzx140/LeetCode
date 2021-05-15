package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/">https://leetcode.com/problems/diameter-of-binary-tree/</a>
 */
public class No543DiameterOfBinaryTree {
  private int res = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    recursion(root);
    return res;
  }

  private int recursion(TreeNode root) {
    if (root == null) return 0;

    int left = recursion(root.left);
    int right = recursion(root.right);
    res = Math.max(left + right, res);

    return Math.max(left, right) + 1;
  }
}
