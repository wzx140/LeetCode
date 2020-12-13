package com.wzx.entity;

import com.wzx.leetcode.No32PrintTheBinaryTreeFromTopToBottom3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树数据结构
 *
 * @author wzx
 */
public class TreeNode {
  public int val;
  public TreeNode left = null;
  public TreeNode right = null;
  public TreeNode parent = null;

  public TreeNode(int val) {
    this.val = val;
  }

  public static boolean treeEquals(TreeNode tree1, TreeNode tree2) {
    if (tree1 == null && tree2 == null) {
      return true;
    }
    if (tree1 == null || tree2 == null) {
      return false;
    }
    if (tree1.val == tree2.val) {
      return treeEquals(tree1.left, tree2.left) && treeEquals(tree1.right, tree2.right);
    } else {
      return false;
    }
  }

  public static TreeNode buildTree(List<Integer> source) {
    if (source.isEmpty()) return null;

    TreeNode root = new TreeNode(source.get(0));
    // 上一层的所有节点
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int cur = 1;
    while (cur < source.size()) {

      TreeNode parent = queue.poll();
      if (cur < source.size() && source.get(cur) != null) {
        parent.left = new TreeNode(source.get(cur));
        queue.add(parent.left);
      }
      cur++;
      if (cur < source.size() && source.get(cur) != null) {
        parent.right = new TreeNode(source.get(cur));
        queue.add(parent.right);
      }
      cur++;
    }

    return root;
  }

  @Override
  public String toString() {
    No32PrintTheBinaryTreeFromTopToBottom3 solution = new No32PrintTheBinaryTreeFromTopToBottom3();
    return solution.levelOrder1(this).toString();
  }
}
