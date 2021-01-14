package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/">https://leetcode.com/problems/reverse-linked-list-ii/</a>
 */
public class No92ReverseLinkedList2 {

  /**
   * time: O(n)
   * space: O(1)
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode sentinel = new ListNode();
    sentinel.next = head;
    // 起始结点的前一个结点
    ListNode preStart = sentinel;
    for (int i = 1; i < m; i++) preStart = preStart.next;
    // 翻转内部结点(2~4)
    // 1 -> 2  ->  3 -> 4 -> 5 -> null
    // 1 -> 2 -><- 3 <- 4    5 -> null
    ListNode pre = preStart.next, cur = pre.next;
    int len = n - m;
    for (int i = 0; i < len; i++) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    // 处理尾结点(2->5)
    // 1 -> 2 -><- 3 <- 4    5 -> null
    //      4  ->  3 -> 2 -> 5 -> null  1 -> 2
    preStart.next.next = cur;
    // 处理头结点(1->4)
    // 1 -> 2
    // 1 -> 4 -> 3 -> 2 -> 5 -> null
    preStart.next = pre;
    return sentinel.next;
  }

}
