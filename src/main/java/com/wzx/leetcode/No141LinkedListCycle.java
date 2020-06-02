package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * @author wzx
 */
public class No141LinkedListCycle {

  /**
   * 快慢指针
   *
   * time: O(n)
   * space: O(1)
   */
  public boolean hasCycle1(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null && slow != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }

    return false;
  }
}
