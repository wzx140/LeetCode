package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">https://leetcode.com/problems/invert-binary-tree/</a>
 *
 * @author wzx
 */
public class No226InvertBinaryTree {

  /**
   * 前序遍历
   * <p>
   * time: O(n)
   * space: O(h)
   */
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    invertTree(root.left);
    invertTree(root.right);

    return root;
  }
}
