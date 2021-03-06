package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">https://leetcode.com/problems/add-two-numbers/</a>
 * @author wzx
 */
public class No2AddTwoNumbers {

  /**
   * time: O(max(m, n))
   * space: O(max(m, n))
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode sent = new ListNode();
    int carry = 0;

    ListNode node = sent;
    while (l1 != null || l2 != null || carry != 0) {
      int value1 = l1 != null ? l1.val : 0;
      int value2 = l2 != null ? l2.val : 0;
      int res = value1 + value2 + carry;

      node.next = new ListNode(res % 10);
      carry = res / 10;
      node = node.next;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }

    return sent.next;
  }
}
