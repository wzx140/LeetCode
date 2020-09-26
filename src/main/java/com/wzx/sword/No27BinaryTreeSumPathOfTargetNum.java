package com.wzx.sword;

import com.wzx.entity.TreeNode;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca
 *
 * @author wzx
 */
public class No27BinaryTreeSumPathOfTargetNum {

  /**
   * 递归
   *
   * time: O(n)
   * space: O(n)
   */
  public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    recursion(res, new ArrayList<>(), root, target);
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
  private static void recursion(ArrayList<ArrayList<Integer>> paths,
                                ArrayList<Integer> path,
                                TreeNode node,
                                int target) {
    path.add(node.val);
    int nextTarget = target - node.val;
    // 正好到叶子结点，且路径和正好为target
    if (nextTarget == 0 && node.left == null && node.right == null) {
      paths.add(new ArrayList<>(path));
    }

    // 空结点和路径和超过target时，不需继续遍历
    if (node.left != null && nextTarget >= 0) recursion(paths, path, node.left, nextTarget);
    if (node.right != null && nextTarget >= 0) recursion(paths, path, node.right, nextTarget);
    // 遍历结束，回溯
    path.remove(path.size() - 1);
  }
}
