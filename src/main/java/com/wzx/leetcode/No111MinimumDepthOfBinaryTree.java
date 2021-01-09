package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">https://leetcode.com/problems/minimum-depth-of-binary-tree/</a>
 * @author wzx
 */
public class No111MinimumDepthOfBinaryTree {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int minDepth1(TreeNode root) {
    if (root == null) return 0;

    // 主要一定要遍历到叶子结点，所有当有一个子结点为空时，需要继续向下遍历
    if (root.left != null && root.right == null) {
      return minDepth1(root.left) + 1;
    } else if (root.right != null && root.left == null) {
      return minDepth1(root.right) + 1;
    } else {
      return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
    }
  }

  /**
   * 广搜
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int minDepth2(TreeNode root) {
    if (root == null) return 0;

    Deque<TreeNode> queue = new LinkedList<>();
    int minDepth = 0;
    queue.addLast(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      minDepth++;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollFirst();
        if (node.left == null && node.right == null) {
          return minDepth;
        }

        if (node.left != null) queue.addLast(node.left);
        if (node.right != null) queue.addLast(node.right);
      }
    }

    return minDepth;
  }
}
