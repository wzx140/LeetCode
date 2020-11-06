package com.wzx.sword;

import com.wzx.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 *
 * @author wzx
 */
public class No37SerializedBinaryTree {

  private int offset = 0;
  private TreeNode getNextNode(String str) {
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
  public class Codec1{

    /**
     * 层序遍历
     * <p>
     * time: O(n)
     * space: O(n)
     */
    public String serialize(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      if (root != null) queue.add(root);

      StringBuilder sb = new StringBuilder();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node == null) {
          sb.append('#');
        } else {
          sb.append(node.val).append('!');
          queue.add(node.left);
          queue.add(node.right);
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
      TreeNode root = getNextNode(data);

      // 已反序列化的所有节点
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (offset < data.length()) {

        TreeNode parent = queue.poll();
        // 左子结点
        TreeNode left = getNextNode(data);
        if (left != null) {
          parent.left = left;
          queue.add(parent.left);
        }
        // 右子结点
        if (offset < data.length()) {
          TreeNode right = getNextNode(data);
          if (right != null) {
            parent.right = right;
            queue.add(parent.right);
          }
        }

      }

      return root;
    }
  }

  /**
   * 扩充二叉树前序遍历
   */
  public class Codec2{

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
      return recursion(data);
    }

    private TreeNode recursion(String str) {

      if (offset >= str.length()) return null;

      TreeNode node = getNextNode(str);
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
  public class Codec3{

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
          while (numStart-- > 0){
            if (data.charAt(numStart) == '!' || data.charAt(numStart) == '#'){
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

      return recursion(sb.toString());
    }

    private TreeNode recursion(String str) {

      if (offset >= str.length()) return null;

      TreeNode node = getNextNode(str);
      if (node != null) {
        node.right = recursion(str);
        node.left = recursion(str);
      }

      return node;
    }
  }
}
