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
    rank = 0;
    res = 0;
    helper(root, k);
    return res;
  }

  private void helper(TreeNode root, int k) {
    if (root == null) return;
    helper(root.left, k);
    rank++;
    if (rank == k) {
      res = root.val;
      return;
    }
    helper(root.right, k);
  }
}
