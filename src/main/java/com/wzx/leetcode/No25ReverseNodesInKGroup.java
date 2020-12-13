package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * @author wzx
 */
public class No25ReverseNodesInKGroup {

  /**
   * 递归反转链表
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) return null;

    ListNode start = head;
    ListNode end = head;

    for (int i = 0; i < k; i++) {
      // 不足k个, 不需要反转
      if (end == null) return head;
      end = end.next;
    }

    // 反转链表
    ListNode newHead = reverse(start, end);
    // 反转后的链表结尾接的是下一个反转链表
    start.next = reverseKGroup(end, k);
    return newHead;
  }

  private ListNode reverse(ListNode start, ListNode end) {
    ListNode cur = start, pre = end;
    while (cur != end) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }
}
