package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * @author wzx
 */
public class No92ReverseLinkedList2 {

  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode start = head;
    ListNode preStart = head;
    for (int i = 0; i < m - 2; i++) {
      preStart = preStart.next;
    }
    if (m == 1) {
      preStart = null;
    } else {
      start = preStart.next;
    }

    // 逆转中间结点
    ListNode pre = start;
    ListNode cur = pre.next;
    int len = n - m;
    for (int i = 0; i < len && cur != null; i++) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }

    // 处理首末结点
    if (preStart != null) {
      preStart.next = pre;
    } else {
      head = pre;
    }
    start.next = cur;

    return head;
  }

}
