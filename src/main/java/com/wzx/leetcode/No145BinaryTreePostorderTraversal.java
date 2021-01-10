package com.wzx.leetcode;

import com.wzx.entity.TreeNode;

import java.util.*;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">https://leetcode.com/problems/binary-tree-postorder-traversal/</a>
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
   * 带标志位的迭代
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    // (结点, 该节点的访问状态)
    Deque<Map.Entry<TreeNode, State>> stack = new LinkedList<>();
    if (root != null) stack.addFirst(new AbstractMap.SimpleEntry<>(root, State.LEFT));
    while (!stack.isEmpty()) {
      Map.Entry<TreeNode, State> entry = stack.peekFirst();
      TreeNode node = entry.getKey();
      State state = entry.getValue();

      if (state == State.LEFT) {
        // 先访问左子树
        entry.setValue(State.RIGHT);
        if (node.left != null) stack.addFirst(new AbstractMap.SimpleEntry<>(node.left, State.LEFT));
      } else if (state == State.RIGHT) {
        // 再访问右子树
        entry.setValue(State.CUR);
        if (node.right != null) stack.addFirst(new AbstractMap.SimpleEntry<>(node.right, State.LEFT));
      } else {
        // 最后访问当前结点
        res.add(node.val);
        stack.removeFirst();
      }
    }

    return res;
  }

  /**
   * 迭代
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> postorderTraversal3(TreeNode root) {
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

  private enum State {
    // 左子结点没有访问
    LEFT,
    // 右子结点没有访问
    RIGHT,
    // 结点没有访问
    CUR
  }
}
