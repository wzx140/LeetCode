package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author wzx
 */
public class No21MergeTwoSortedLists {

  /**
   * time: O(n)
   * space: O(1)
   */
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    ListNode head = new ListNode();
    ListNode node = head;
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

    return head.next;
  }
}
