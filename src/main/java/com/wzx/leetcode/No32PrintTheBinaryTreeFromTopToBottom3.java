package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *
 * @author wzx
 */
public class No32PrintTheBinaryTreeFromTopToBottom3 {

  /**
   * 栈和队列结合
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<List<Integer>> levelOrder1(TreeNode root) {
    if (root == null) return new LinkedList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    queue.addLast(root);
    res.add(Collections.singletonList(root.val));
    boolean order = true;

    while (!queue.isEmpty()) {
      while (!queue.isEmpty()) {
        TreeNode node = queue.pollFirst();
        // stack用于对queue中当前层进行逆序
        if (order) {
          if (node.left != null) stack.addFirst(node.left);
          if (node.right != null) stack.addFirst(node.right);
        } else {
          if (node.right != null) stack.addFirst(node.right);
          if (node.left != null) stack.addFirst(node.left);
        }
      }
      List<Integer> layer = new LinkedList<>();
      while (!stack.isEmpty()) {
        TreeNode node = stack.pollFirst();
        layer.add(node.val);
        queue.addLast(node);
      }
      if (!layer.isEmpty()) res.add(layer);
      order = !order;
    }

    return res;
  }

  /**
   * 队列
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<List<Integer>> levelOrder2(TreeNode root) {
    if (root == null) return new LinkedList<>();
    Deque<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    queue.addLast(root);

    while (!queue.isEmpty()) {
      int layerSize = res.size();
      int queueSize = queue.size();
      LinkedList<Integer> layer = new LinkedList<>();
      for (int i = 0; i < queueSize; i++) {
        TreeNode node = queue.pollFirst();
        // 当前层根据层数判断是否逆序
        if ((layerSize & 1) == 0) {
          layer.addLast(node.val);
        } else {
          layer.addFirst(node.val);
        }
        // 下一层
        if (node.left != null) queue.addLast(node.left);
        if (node.right != null) queue.addLast(node.right);
      }
      if (!layer.isEmpty()) res.add(layer);
    }

    return res;
  }
}
