package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/subtree-of-another-tree/">https://leetcode.com/problems/subtree-of-another-tree/</a>
 * @author wzx
 */
public class No572SubtreeOfAnotherTree {

  /**
   * 看两棵拓展二叉树的先根序列是否是包含关系，主要扩充结点需要区分左右
   * <p>
   * time: O(m+n+mn)
   * space: O(max(n, m)) 递归栈的空间复杂度应该是最坏的树高
   */
  public boolean isSubtree1(TreeNode s, TreeNode t) {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    buildString(s, true, sb1);
    buildString(t, true, sb2);

    return sb1.toString().contains(sb2.toString());
  }

  private void buildString(TreeNode tree, boolean left, StringBuilder sb) {
    if (tree == null) {
      if (left) {
        sb.append('&');
      } else {
        sb.append('*');
      }
    } else {
      sb.append('#').append(tree.val);
      buildString(tree.left, true, sb);
      buildString(tree.right, false, sb);
    }
  }

  /**
   * 深搜对比
   *
   * time: O(mn)
   * space: O(m) 第一棵树的深度最坏为m
   */
  public boolean isSubtree2(TreeNode s, TreeNode t) {

    return s != null && (TreeNode.treeEquals(s, t)
            || isSubtree2(s.left, t)
            || isSubtree2(s.right, t));
  }
}
