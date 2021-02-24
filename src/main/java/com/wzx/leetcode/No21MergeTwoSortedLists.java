package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">https://leetcode.com/problems/merge-two-sorted-lists/</a>
 */
public class No21MergeTwoSortedLists {

  /**
   * 二路归并
   * time: O(n)
   * space: O(1)
   */
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    ListNode sent = new ListNode();
    ListNode node = sent;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        node.next = l2;
        l2 = l2.next;
      } else if (l2 == null) {
        node.next = l1;
        l1 = l1.next;
      } else {
        if (l1.val < l2.val) {
          node.next = l1;
          l1 = l1.next;
        } else {
          node.next = l2;
          l2 = l2.next;
        }
      }
      node = node.next;
    }

    return sent.next;
  }
}
