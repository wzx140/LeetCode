package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">https://leetcode.com/problems/binary-tree-maximum-path-sum/</a>
 */
public class No124BinaryTreeMaximumPathSum {

  private int res = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    res = Integer.MIN_VALUE;
    recursion(root);
    return res;
  }

  private int recursion(TreeNode root) {
    if (root == null) return 0;

    // 小于0的路径将被舍去
    int left = Math.max(recursion(root.left), 0);
    int right = Math.max(recursion(root.right), 0);
    res = Math.max(res, root.val + left + right);

    // 返回root的最长一条左或右路径
    return root.val + Math.max(left, right);
  }
}
