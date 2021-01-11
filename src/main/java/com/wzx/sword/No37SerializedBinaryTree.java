package com.wzx.sword;

import com.wzx.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof">https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof</a>
 */
public class No37SerializedBinaryTree {

  private int offset = 0;
  private String str = null;

  private TreeNode getNextNode() {
    String num = "";
    char ch;
    while ((ch = str.charAt(offset++)) != '!') {
      if (ch == '#') return null;
      // 可能存在许多位数为1，2的数，频繁创建StringBuilder不太好
      num += ch;
    }

    return new TreeNode(Integer.parseInt(num));
  }

  /**
   * 扩充二叉树层序遍历
   */
  public class Codec1 {

    /**
     * 层序遍历
     * <p>
     * time: O(n)
     * space: O(n)
     */
    public String serialize(TreeNode root) {
      Deque<TreeNode> queue = new LinkedList<>();
      if (root != null) queue.add(root);

      StringBuilder sb = new StringBuilder();
      while (!queue.isEmpty()) {
        TreeNode node = queue.pollLast();
        if (node == null) {
          sb.append('#');
        } else {
          sb.append(node.val).append('!');
          queue.addFirst(node.left);
          queue.addFirst(node.right);
        }
      }

      return sb.toString();
    }

    /**
     * 反序列化，层序遍历
     * <p>
     * time: O(n)
     * space: O(n)
     */
    public TreeNode deserialize(String data) {
      if (data.isEmpty()) return null;
      offset = 0;
      str = data;
      TreeNode root = getNextNode();

      // 已反序列化的所有节点
      Deque<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (offset < data.length()) {
        TreeNode node = queue.pollLast();
        // 左子结点
        TreeNode left = getNextNode();
        if (left != null) {
          node.left = left;
          queue.addFirst(node.left);
        }
        // 右子结点
        if (offset < data.length()) {
          TreeNode right = getNextNode();
          if (right != null) {
            node.right = right;
            queue.addFirst(node.right);
          }
        }

      }

      return root;
    }
  }

  /**
   * 扩充二叉树前序遍历
   */
  public class Codec2 {

    /**
     * 前序遍历
     * <p>
     * time: 0(n)
     * space: O(n)
     */
    public String serialize(TreeNode root) {
      if (root == null) return null;

      StringBuilder sb = new StringBuilder();
      recursion(root, sb);

      return sb.toString();
    }

    private void recursion(TreeNode root, StringBuilder sb) {
      if (root == null) {
        sb.append('#');
        return;
      }

      sb.append(root.val).append('!');
      recursion(root.left, sb);
      recursion(root.right, sb);
    }

    /**
     * 前序遍历 = {root, left, right}
     * <p>
     * time: O(n)
     * space: O(n)
     */
    public TreeNode deserialize(String data) {
      if (data == null) return null;
      offset = 0;
      str = data;
      return recursion(data);
    }

    private TreeNode recursion(String str) {
      if (offset >= str.length()) return null;

      TreeNode node = getNextNode();
      if (node != null) {
        node.left = recursion(str);
        node.right = recursion(str);
      }

      return node;
    }
  }

  /**
   * 扩充二叉树后序遍历
   */
  public class Codec3 {

    /**
     * 后序遍历
     * <p>
     * time: O(n)
     * space: O(n)
     */
    public String serialize(TreeNode root) {
      if (root == null) return null;

      StringBuilder sb = new StringBuilder();
      recursion(root, sb);

      return sb.toString();
    }

    private void recursion(TreeNode root, StringBuilder sb) {
      if (root == null) {
        sb.append('#');
        return;
      }

      recursion(root.left, sb);
      recursion(root.right, sb);
      sb.append(root.val).append('!');
    }

    /**
     * 后序遍历 = {left, right, root}
     * <p>
     * time: O(n)
     * space: O(n)
     */
    public TreeNode deserialize(String data) {
      if (data == null) return null;
      offset = 0;

      StringBuilder sb = new StringBuilder(data.length());
      // reverse = {root, right, left}
      for (int i = data.length() - 1; i >= 0; i--) {
        if (data.charAt(i) == '!') {
          // 翻转数字
          int numStart = i;
          while (numStart-- > 0) {
            if (data.charAt(numStart) == '!' || data.charAt(numStart) == '#') {
              numStart++;
              break;
            }
          }
          for (int j = numStart; j <= i; j++) sb.append(data.charAt(j));
          i = numStart;
        } else {
          sb.append(data.charAt(i));
        }
      }

      str = sb.toString();
      return recursion(str);
    }

    private TreeNode recursion(String str) {

      if (offset >= str.length()) return null;

      TreeNode node = getNextNode();
      if (node != null) {
        node.right = recursion(str);
        node.left = recursion(str);
      }

      return node;
    }
  }
}
