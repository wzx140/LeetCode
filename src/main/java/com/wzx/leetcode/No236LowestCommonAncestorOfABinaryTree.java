package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/</a>
 */
public class No236LowestCommonAncestorOfABinaryTree {

  /**
   * 后序遍历递归
   * <p>
   * - 若p,q都是root的子树, 返回最近公共祖先
   * <p>
   * - 若p,q有一者是root的子树, 返回p或q
   * <p>
   * - 若都不是, 返回null
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (root == p || root == q) return root;

    // 返回的left和right起到标识p, q是否分别在root的左右子树上
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
      // left和right只会分别存在于最近公共祖先的左右侧
      return root;
    }
    // 若p,q有一者是root的子树, 返回p或q
    // 向上传递标记p或q是root的子树, 向上传递LCA
    else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }
    // 当前子树不存在p与q
    else {
      return null;
    }
  }
}
