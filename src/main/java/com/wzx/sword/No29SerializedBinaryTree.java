package com.wzx.sword;

import com.wzx.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84
 *
 * @author wzx
 */
public class No29SerializedBinaryTree {

  private int offset = 0;

  /**
   * 扩充二叉树的前序，后序，层序遍历
   */

  /**
   * 层序遍历
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public String Serialize1(TreeNode root) {
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
  public TreeNode Deserialize1(String str) {
    if (str.isEmpty()) return null;
    offset = 0;
    TreeNode root = getNextNode(str);

    // 已反序列化的所有节点
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (offset < str.length()) {

      TreeNode parent = queue.poll();
      // 左子结点
      TreeNode left = getNextNode(str);
      if (left != null) {
        parent.left = left;
        queue.add(parent.left);
      }
      // 右子结点
      if (offset < str.length()) {
        TreeNode right = getNextNode(str);
        if (right != null) {
          parent.right = right;
          queue.add(parent.right);
        }
      }

    }

    return root;
  }

  /**
   * 前序遍历
   * <p>
   * time: 0(n)
   * space: O(n)
   */
  public String Serialize2(TreeNode root) {
    if (root == null) return null;

    StringBuilder sb = new StringBuilder();
    recursion21(root, sb);

    return sb.toString();
  }

  private void recursion21(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append('#');
      return;
    }

    sb.append(root.val).append('!');
    recursion21(root.left, sb);
    recursion21(root.right, sb);
  }

  /**
   * 前序遍历 = {root, left, right}
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public TreeNode Deserialize2(String str) {
    if (str == null) return null;
    offset = 0;
    return recursion21(str);
  }

  public TreeNode recursion21(String str) {

    if (offset >= str.length()) return null;

    TreeNode node = getNextNode(str);
    if (node != null) {
      node.left = recursion21(str);
      node.right = recursion21(str);
    }

    return node;
  }

  /**
   * 后序遍历
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public String Serialize31(TreeNode root) {
    if (root == null) return null;

    StringBuilder sb = new StringBuilder();
    recursion31(root, sb);

    return sb.toString();
  }

  private void recursion31(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append('#');
      return;
    }

    recursion31(root.left, sb);
    recursion31(root.right, sb);
    sb.append(root.val).append('!');
  }

  /**
   * 后序遍历 = {left, right, root}
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public TreeNode Deserialize3(String str) {
    if (str == null) return null;
    offset = 0;

    StringBuilder sb = new StringBuilder(str.length());
    // reverse = {root, right, left}
    for (int i = str.length() - 1; i >= 0; i--) {
      if (str.charAt(i) == '!') {
        // 翻转数字
        int numStart = i;
        while (numStart-- > 0){
          if (str.charAt(numStart) == '!' || str.charAt(numStart) == '#'){
            numStart++;
            break;
          }
        }
        for (int j = numStart; j <= i; j++) sb.append(str.charAt(j));
        i = numStart;
      } else {
        sb.append(str.charAt(i));
      }
    }

    return recursion31(sb.toString());
  }

  private TreeNode recursion31(String str) {

    if (offset >= str.length()) return null;

    TreeNode node = getNextNode(str);
    if (node != null) {
      node.right = recursion31(str);
      node.left = recursion31(str);
    }

    return node;
  }

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
}
