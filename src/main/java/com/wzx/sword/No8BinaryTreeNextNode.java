package com.wzx.sword;

import com.wzx.entity.TreeNode;

/**
 * https://github.com/todorex/Coding-Interviews/blob/master/notes/%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E4%B8%8B%E4%B8%80%E4%B8%AA%E8%8A%82%E7%82%B9.md
 *
 * @author wzx
 */
public class No8BinaryTreeNextNode {

  /**
   * |     0
   * |  1     2
   * |3  4   5  6
   * <p>
   * 3 1 4 0 5 2 6
   * <p>
   * 中序遍历的逆推
   * 1. 有右子树，返回右子树中最左结点
   * 2. 没有右子树，找到是左子结点的祖先结点，返回父结点
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public static TreeNode GetNext(TreeNode pNode) {
    if (null == pNode) return null;

    TreeNode next = null;
    if (pNode.right != null) {
      next = pNode.right;
      while (next.left != null) next = next.left;
    } else {
      next = pNode;
      while (next.parent.left != next) next = next.parent;
      next = next.parent;
    }

    return next;
  }

}
