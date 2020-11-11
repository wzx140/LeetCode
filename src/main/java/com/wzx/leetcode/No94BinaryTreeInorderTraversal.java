package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * @author wzx
 */
public class No94BinaryTreeInorderTraversal {


  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> inorderTraversal1(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    recursion(root, res);
    return res;
  }

  private void recursion(TreeNode root, List<Integer> res) {
    if (root == null) return;
    recursion(root.left, res);
    res.add(root.val);
    recursion(root.right, res);
  }

  /**
   * 带标志位的迭代
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) return res;

    // (结点,该节点是否访问过左子树)
    Deque<Map.Entry<TreeNode, Boolean>> stack = new LinkedList<>();
    stack.addFirst(new AbstractMap.SimpleEntry<>(root, false));
    while (!stack.isEmpty()) {
      Map.Entry<TreeNode, Boolean> entry = stack.peekFirst();
      boolean left = entry.getValue();
      TreeNode node = entry.getKey();
      if (!left) {
        // 没有访问过左子树，先访问左子树再访问当前结点
        entry.setValue(true);
        if (node.left != null) stack.addFirst(new AbstractMap.SimpleEntry<>(node.left, false));
      } else {
        // 访问过左子树，先访问当前结点再访问右子树
        res.add(node.val);
        stack.pollFirst();
        if (node.right != null) stack.addFirst(new AbstractMap.SimpleEntry<>(node.right, false));
      }
    }

    return res;
  }

  /**
   * 迭代
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> inorderTraversal3(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    // 当前遍历结点(未访问过左子树)
    TreeNode cur = root;
    // 缓存已访问过左子树的结点
    Deque<TreeNode> stack = new LinkedList<>();
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        // 先遍历左子树
        stack.addFirst(cur);
        cur = cur.left;
      } else {
        // 左子树为空时，先保存当前结点，再遍历右子树
        TreeNode node = stack.pollFirst();
        res.add(node.val);
        cur = node.right;
      }
    }

    return res;
  }
}
