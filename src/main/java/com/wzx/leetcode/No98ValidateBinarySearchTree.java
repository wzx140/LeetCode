package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">https://leetcode.com/problems/validate-binary-search-tree/</a>
 * @author wzx
 */
public class No98ValidateBinarySearchTree {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public boolean isValidBST(TreeNode root) {
    // null标记初始值, 不能使用Integer.MAX_VALUE和Integer.MIN_VALUE作为初始值
    return recursion(root, null, null);
  }

  /**
   * root为当前子树根结点, 取值范围在(min, max)
   * @param max: 右子树的最小值
   * @param min: 左子树的最大值
   */
  private boolean recursion(TreeNode root, Integer max, Integer min) {
    if (root == null) return true;

    if (max != null && root.val > max) return false;
    if (min != null && root.val < min) return false;

    // 左子树的所有结点小于根结点值, 所以根结点值为左子树的最大值
    return recursion(root.left, root.val, min)
            // 右子树的所有结点大于根结点值, 所以根结点值为右子树的最小值
            && recursion(root.right, max, root.val);
  }
}
