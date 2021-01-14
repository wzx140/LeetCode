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
  public ListNode reverseList(ListNode head) {
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

}
