package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">https://leetcode.com/problems/reverse-linked-list/</a>
 */
public class No206ReverseLinkedList {

  /**
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
   * 头插法
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public ListNode reverseList2(ListNode head) {
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
