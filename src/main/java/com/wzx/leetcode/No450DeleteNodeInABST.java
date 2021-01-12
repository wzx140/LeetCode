package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/delete-node-in-a-bst/">https://leetcode.com/problems/delete-node-in-a-bst/</a>
 * @author wzx
 */
public class No450DeleteNodeInABST {

  /**
   * 递归
   *
   * time: O(h)
   * space: O(h)
   */
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      // 情况一：删除叶结点
      if (root.left == null && root.right == null) return null;

      // 情况二：子结点替换一元结点
      if (root.left == null) return root.right;
      if (root.right == null) return root.left;

      // 情况三：左子树中最大结点或右子树中最小结点替换二元结点
      TreeNode minRight = root.right;
      while (minRight.left != null) minRight = minRight.left;
      // 替换root
      root.val = minRight.val;
      // 删除右子树最小结点
      root.right = deleteNode(root.right, minRight.val);
    }

    return root;
  }
}
