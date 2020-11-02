package com.wzx.sword;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * @author wzx
 */
public class No68NearestCommonAncestorOfBinaryTree {

  /**
   * 递归, 后序遍历
   * <p>
   * time: O(h) 树高
   * space: O(h)
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 后序遍历直到找到p和q才会返回
    if (root == null || p == root || q == root) return root;

    // p, q是否存在于root的左右子树中
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left == null && right == null) {
      // 1. 这条子树不包含p, q
      return null;
    } else if (left != null && right != null) {
      // 2. p,q分别位于root的左右两侧, root即公共祖先结点
      return root;
    } else if (left != null) {
      // 3. root左子树包含p, q, left即由2向上传递的公共祖先结点
      return left;
    } else if (right != null) {
      // 4. root右子树包含p, q, right即由2向上传递的公共祖先结点
      return right;
    }

    return null;
  }

}
