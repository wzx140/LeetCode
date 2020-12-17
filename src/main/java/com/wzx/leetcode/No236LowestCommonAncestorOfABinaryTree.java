package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author wzx
 */
public class No236LowestCommonAncestorOfABinaryTree {

  /**
   * 后序遍历递归
   * - 若p,q都是root的子树, 返回最近公共祖先
   * - 若p,q有一者是root的子树, 返回p或q
   * - 若都不是, 返回null
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (root == p || root == q) return root;

    // 返回的left和right只起到标识的作用
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    // left和right只会分别存在于最近公共祖先的左右侧
    if (left != null && right != null) {
      return root;
    }
    if (left == null && right == null) {
      return null;
    }

    // 若p,q有一者是root的子树, 返回p或q
    return left == null ? right : left;
  }
}
