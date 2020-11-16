package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * @author wzx
 */
public class No113PathSum2 {

  /**
   * 递归
   *
   * time: O(n)
   * space: O(n)
   */
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new LinkedList<>();

    if (root == null) return res;
    recursion(root, sum, res, new LinkedList<>());
    return res;
  }

  private void recursion(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
    if (root.val == sum && root.left == null && root.right == null) {
      path.add(root.val);
      res.add(new LinkedList<>(path));
      path.remove(path.size() - 1);
      return;
    }

    int next = sum - root.val;
    if (root.left != null) {
      path.add(root.val);
      recursion(root.left, next, res, path);
      path.remove(path.size() - 1);
    }
    if (root.right != null) {
      path.add(root.val);
      recursion(root.right, next, res, path);
      path.remove(path.size() - 1);
    }
  }

}
