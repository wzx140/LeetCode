package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">https://leetcode.com/problems/binary-tree-level-order-traversal/</a>
 */
public class No102BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();

    Deque<TreeNode> queue = new LinkedList<>();
    if (root != null) queue.addFirst(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> layer = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollLast();
        layer.add(node.val);
        if (node.left != null) queue.addFirst(node.left);
        if (node.right != null) queue.addFirst(node.right);
      }
      res.add(layer);
    }
    return res;
  }
}
