package com.wzx.sword;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * @author wzx
 */
public class No68NearestCommonAncestorOfBinarySearchTree {

  /**
   * 递归
   * <p>
   * time: O(h) h树高
   * space: O(h)
   */
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;

    if (root.val > p.val && root.val > q.val) {
      // 都在左子树
      return lowestCommonAncestor1(root.left, p, q);
    } else if (root.val < p.val && root.val < q.val) {
      // 都在右子树
      return lowestCommonAncestor1(root.right, p, q);
    } else {
      // 不同侧
      return root;
    }
  }

  /**
   * 迭代
   * <p>
   * time: O(h) h树高
   * space: O(1)
   */
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    // 迭代前约束p,q大小关系
    if (p.val > q.val) {
      TreeNode tmp = p;
      p = q;
      q = tmp;
    }

    while (root != null) {
      // 迭代前约束了大小, 所以可以减少判断一个条件
      if (root.val > q.val) {
        // 都在左子树
        root = root.left;
      } else if (root.val < p.val) {
        // 都在右子树
        root = root.right;
      } else {
        // 不同侧
        return root;
      }
    }
    return null;
  }
}
