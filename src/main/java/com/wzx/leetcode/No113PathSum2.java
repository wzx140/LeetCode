package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/path-sum-ii/">https://leetcode.com/problems/path-sum-ii/</a>
 */
public class No113PathSum2 {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new LinkedList<>();
    recursion(root, sum, new LinkedList<>(), res);
    return res;
  }

  private void recursion(TreeNode root,
                         int sum,
                         LinkedList<Integer> track,
                         List<List<Integer>> res) {
    if (root == null) return;
    if (sum == root.val && root.left == null && root.right == null) {
      track.add(root.val);
      res.add(new LinkedList<>(track));
      track.removeLast();
      return;
    }

    track.add(root.val);
    recursion(root.left, sum - root.val, track, res);
    recursion(root.right, sum - root.val, track, res);
    track.removeLast();
  }

}
