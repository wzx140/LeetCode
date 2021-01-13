package com.wzx.sword;

import com.wzx.entity.TreeNode;

/**
 * @see <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/">https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/</a>
 * @author wzx
 */
public class No54TheKLargestNodeOfTheBinarySearchTree {

  // 当前第i大结点
  private int res = 0;
  // 结点值
  private int rank = 0;

  /**
   * 中序遍历的倒序
   * <p>
   * time: O(n)
   * space: O(h)
   */
  public int kthLargest(TreeNode root, int k) {
    recursion(root, k);
    return res;
  }

  private void recursion(TreeNode root, int k) {
    if (root == null) return;

    recursion(root.right, k);
    rank++;
    if (rank == k) {
      res = root.val;
      return;
    }
    recursion(root.left, k);
  }
}
