package com.wzx.entity;

import java.util.ArrayList;
import java.util.List;

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
    List<TreeNode> nodes = new ArrayList<>(source.size());
    nodes.add(root);
    // 上一层开始结点的偏移量
    int preLayer = 0;
    // 当前层的偏移量
    int cur = 1;
    while (cur < source.size()) {

      int tmp = cur;
      for (int i = preLayer; i < nodes.size(); i++) {
        TreeNode parent = nodes.get(i);

        if (cur < source.size() && source.get(cur) != null) {
          parent.left = new TreeNode(source.get(cur));
          nodes.add(parent.left);
        }
        cur++;
        if (cur < source.size() && source.get(cur) != null) {
          parent.right = new TreeNode(source.get(cur));
          nodes.add(parent.right);
        }
        cur++;
      }

      preLayer = tmp;
    }

    return root;
  }

  public TreeNode cloneThis() {
    return dfs(this);
  }

  private static TreeNode dfs(TreeNode node) {
    if (node == null) return null;

    TreeNode cloneNode = new TreeNode(node.val);
    cloneNode.left = dfs(node.left);
    cloneNode.right = dfs(node.right);

    return cloneNode;
  }
}
