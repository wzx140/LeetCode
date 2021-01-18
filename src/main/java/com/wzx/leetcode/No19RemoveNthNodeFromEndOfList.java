package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">https://leetcode.com/problems/remove-nth-node-from-end-of-list/</a>
 */
public class No19RemoveNthNodeFromEndOfList {

  /**
   * 快慢指针
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // 哨兵处理删除头结点的情况
    ListNode sent = new ListNode(-1);
    sent.next = head;
    // 快指针比慢指针快n个节点
    ListNode preSlow = sent, slow = head, fast = head;
    while (n-- != 0) fast = fast.next;
    // 快慢指针
    while (fast != null) {
      preSlow = slow;
      slow = slow.next;
      fast = fast.next;
    }
    // 删除慢指针处的结点
    preSlow.next = slow.next;

    return sent.next;
  }
}
