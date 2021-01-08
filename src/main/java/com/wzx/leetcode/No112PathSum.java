package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/path-sum/">https://leetcode.com/problems/path-sum/</a>
 * @author wzx
 */
public class No112PathSum {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(h)
   */
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.val == sum && root.left == null && root.right == null) return true;

    int nextSum = sum - root.val;
    return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum);
  }
}
