package com.wzx.sword;

import com.wzx.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 *
 * @author wzx
 */
public class No34BinaryTreeSumPathOfTargetNum {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(h) 树高
   */
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    recursion(res, new ArrayList<>(), root, sum);
    return res;
  }

  /**
   * 前序遍历
   *
   * @param paths  全部路径
   * @param path   当前路径
   * @param node   当前结点
   * @param target 剩余目标值
   */
  private void recursion(List<List<Integer>> paths,
                         List<Integer> path,
                         TreeNode node,
                         int target) {
    path.add(node.val);
    int nextTarget = target - node.val;
    // 正好到叶子结点，且路径和正好为target
    if (nextTarget == 0 && node.left == null && node.right == null) {
      paths.add(new ArrayList<>(path));
    }

    if (node.left != null) recursion(paths, path, node.left, nextTarget);
    if (node.right != null) recursion(paths, path, node.right, nextTarget);
    // 遍历结束，回溯
    path.remove(path.size() - 1);
  }
}
