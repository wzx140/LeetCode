package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * @author wzx
 */
public class No206ReverseLinkedList {

  /**
   * time: O(n)
   * space: O(1)
   */
  public ListNode reverseList1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode pre = head;
    ListNode cur = head.next;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    head.next = null;

    return pre;
  }

}
