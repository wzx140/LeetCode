package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">https://leetcode.com/problems/reverse-linked-list/</a>
 */
public class No206ReverseLinkedList {

  /**
   * 迭代
   * time: O(n)
   * space: O(1)
   */
  public ListNode reverseList1(ListNode head) {
    if (head == null) return null;
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  /**
   * 递归
   * time: O(n)
   * space: O(n)
   */
  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // reverseList2 返回是已经翻转好的链表
    ListNode newHead = reverseList2(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  /**
   * 头插法
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public ListNode reverseList3(ListNode head) {
    if (head == null) return null;
    ListNode sent = new ListNode();
    sent.next = head;
    ListNode node = head;
    // sent -> x -> node -> next -> y
    // sent -> next -> x -> node -> y
    while (node.next != null) {
      ListNode next = node.next;
      node.next = next.next;
      next.next = sent.next;
      sent.next = next;
    }

    return sent.next;
  }

}
