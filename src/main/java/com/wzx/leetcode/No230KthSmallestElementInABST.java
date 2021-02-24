package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">https://leetcode.com/problems/kth-smallest-element-in-a-bst/</a>
 * @author wzx
 */
public class No230KthSmallestElementInABST {

  private int rank = 0;
  private int res = 0;

  /**
   * BST的中序遍历+全局变量
   *
   * time: O(n)
   * space: O(n)
   */
  public int kthSmallest(TreeNode root, int k) {
    rank = k;
    res = 0;
    helper(root);
    return res;
  }

  private void helper(TreeNode root) {
    if (root == null) return;
    helper(root.left);
    rank--;
    if (rank == 0) {
      res = root.val;
      return;
    }
    helper(root.right);
  }
}
