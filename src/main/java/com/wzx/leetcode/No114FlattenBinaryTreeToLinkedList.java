package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">https://leetcode.com/problems/flatten-binary-tree-to-linked-list/</a>
 * @author wzx
 */
public class No114FlattenBinaryTreeToLinkedList {

  private TreeNode pre = null;

  /**
   * 递归，后序遍历
   * time: O(n^2)
   * space: O(h) 树高
   */
  public void flatten1(TreeNode root) {
    if (root == null) return;

    flatten1(root.left);
    flatten1(root.right);
    TreeNode left = root.left;
    TreeNode right = root.right;
    // 左子树移动到右子树位置
    root.left = null;
    root.right = left;
    // 右子树接在现右子树后面
    while (root.right != null) root = root.right;
    root.right = right;
  }

  /**
   * 递归，反前序遍历，前序遍历正好对应着展开的顺序
   * time: O(n)
   * space: O(h) 树高
   */
  public void flatten2(TreeNode root) {
    if (null == root) return;
    TreeNode right = root.right;
    TreeNode left = root.left;

    // 先展开右子树，再展开左子树
    flatten2(right);
    flatten2(left);
    // 前一个访问的结点接在下一个结点的右子结点处
    root.left = null;
    root.right = pre;
    pre = root;
  }
}
