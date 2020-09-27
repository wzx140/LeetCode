package com.wzx.sword;

import com.wzx.entity.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/submissions/
 *
 * @author wzx
 */
public class No28BST2DoublyLinkedList {

  private static TreeNode pre = null;
  private static TreeNode head = null;

  /**
   * 前序遍历中更改指针，用全局变量pre保存前序遍历的前一个结点
   *
   * time: O(n)
   * space: O(h) 树高
   */
  public static TreeNode Convert(TreeNode pRootOfTree) {
    if (pRootOfTree == null) return null;

    recursion(pRootOfTree);
    // 前序遍历后，pre处在最后一个
    pre.right = head;
    head.left = pre;

    return head;
  }

  /**
   * 递归过程如下
   * pre = left
   * pre(left) link cur; pre = cur
   * pre(cur) link right; pre = right
   */
  private static void recursion(TreeNode cur) {
    if (cur == null) return;

    recursion(cur.left);
    // pre是cur的前一个结点
    if (pre != null) pre.right = cur;
      // pre为空，说明cur为第一个访问的结点即头结点
    else head = cur;
    cur.left = pre;
    pre = cur;
    recursion(cur.right);
  }

}
