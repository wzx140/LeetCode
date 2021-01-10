package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">https://leetcode.com/problems/binary-tree-preorder-traversal/</a>
 */
public class No144BinaryTreePreorderTraversal {

  /**
   * 递归
   *
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> preorderTraversal1(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    recursion(root, res);
    return res;
  }

  private void recursion(TreeNode root, List<Integer> res) {
    if (root == null) return;
    res.add(root.val);
    recursion(root.left, res);
    recursion(root.right, res);
  }

  /**
   * 迭代
   *
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) return res;

    Deque<TreeNode> stack = new LinkedList<>();
    stack.addFirst(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollFirst();
      // 先访问根结点
      res.add(node.val);
      // 注意左右子结点的入栈顺序
      if (node.right != null) stack.addFirst(node.right);
      if (node.left != null) stack.addFirst(node.left);
    }

    return res;
  }
}
