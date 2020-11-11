package com.wzx.leetcode;

import com.wzx.entity.TreeNode;
import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * @author wzx
 */
public class No145BinaryTreePostorderTraversal {

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> postorderTraversal1(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    recursion(root, res);
    return res;
  }

  private void recursion(TreeNode root, List<Integer> res) {
    if (root == null) return;

    recursion(root.left, res);
    recursion(root.right, res);
    res.add(root.val);
  }

  /**
   * 迭代
   *
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) return res;

    // (结点, 该节点是否访问过右子树) 缓存已访问过左子树的结点
    Deque<Map.Entry<TreeNode, Boolean>> stack = new LinkedList<>();
    // 当前结点(未访问过左子树)
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        // 首先访问左子树
        stack.addFirst(new AbstractMap.SimpleEntry<>(cur, false));
        cur = cur.left;
      } else {
        Map.Entry<TreeNode, Boolean> entry = stack.peekFirst();
        TreeNode node = entry.getKey();
        Boolean right = entry.getValue();
        if (!right) {
          // 其次访问右子树
          entry.setValue(true);
          cur = node.right;
        } else {
          // 最后访问当前结点
          res.add(node.val);
          stack.pollFirst();
        }
      }
    }

    return res;
  }
}
