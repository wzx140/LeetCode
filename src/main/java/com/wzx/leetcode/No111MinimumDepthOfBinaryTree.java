package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * @author wzx
 */
public class No111MinimumDepthOfBinaryTree {

  /**
   * 递归
   *
   * time: O(n)
   * space: O(n)
   */
  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    // 主要一定要遍历到叶子结点，所有当有一个子结点为空时，需要继续向下遍历
    if (root.left != null && root.right == null) {
      return minDepth(root.left) + 1;
    } else if (root.right != null && root.left == null) {
      return minDepth(root.right) + 1;
    } else {
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
  }
}
