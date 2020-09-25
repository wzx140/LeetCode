package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 *
 * @author wzx
 */
public class No654MaximumBinaryTree {

  public TreeNode constructMaximumBinaryTree(int[] nums) {

    return recursion(nums, 0, nums.length - 1);
  }

  /**
   * 递归
   *
   * time: O(n^2)
   * space: O(h) 树高
   */
  private TreeNode recursion(int[] nums, int begin, int end) {
    if (begin == end) return new TreeNode(nums[begin]);
    if (begin > end) return null;

    // 找到最大值
    int maxIndex = begin;
    for (int i = begin; i <= end; i++) {
      if (nums[i] > nums[maxIndex]) {
        maxIndex = i;
      }
    }

    TreeNode root = new TreeNode(nums[maxIndex]);
    root.left = recursion(nums, begin, maxIndex - 1);
    root.right = recursion(nums, maxIndex + 1, end);
    return root;
  }
}
