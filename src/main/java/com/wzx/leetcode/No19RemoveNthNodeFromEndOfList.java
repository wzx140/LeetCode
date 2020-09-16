package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author wzx
 */
public class No19RemoveNthNodeFromEndOfList {

  /**
   * 快慢指针
   *
   * time: O(n)
   * space: O(1)
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode sent = new ListNode();
    sent.next = head;

    ListNode slow = sent;
    ListNode fast = sent;
    n++;
    while (n-- > 0) {
      if (fast == null) return head;
      fast = fast.next;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;

    return sent.next;
  }
}
