package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">https://leetcode.com/problems/reverse-nodes-in-k-group/</a>
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

    // head: 当前group的head
    // tail: 当前group的tail
    ListNode tail = head;
    for (int i = 0; i < k - 1; i++) {
      tail = tail.next;
      // 不足k个, 不需要反转
      if (tail == null) return head;
    }
    // new head = tail
    // new tail = head
    ListNode nextHead = reverse(head, tail);
    // 逆转group之间的连接需要有后至前, 所以应用递归
    head.next = reverseKGroup(nextHead, k);
    return tail;
  }

  private ListNode reverse(ListNode head, ListNode tail) {
    ListNode pre = head, cur = pre.next;
    while (pre != tail) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    // 返回下一个group的head
    return cur;
  }
}
