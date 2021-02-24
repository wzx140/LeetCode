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
    ListNode sent = new ListNode();
    sent.next = head;
    // 快指针比慢指针快n个节点
    ListNode fast = sent, slow = sent;
    while (n-- > 0) {
      fast = fast.next;
    }
    // 快指针指向链表末尾, 慢指针指向目标节点的前一个节点
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    // 删除slow.next节点
    slow.next = slow.next.next;

    return sent.next;
  }
}
