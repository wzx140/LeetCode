package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">https://leetcode.com/problems/maximum-depth-of-binary-tree/</a>
 * @author wzx
 */
public class No104MaximumDepthOfBinaryTree {

  /**
   * 递归
   *
   * time: O(n)
   * space: O(n)
   */
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}
