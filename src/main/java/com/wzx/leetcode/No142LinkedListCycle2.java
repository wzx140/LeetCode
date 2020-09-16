package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * @author wzx
 */
public class No142LinkedListCycle2 {

  /**
   * 快慢指针，快指针和慢指针相遇时，新慢指针从起点出发，就慢指针从当前位置出发，相遇点就是环的起点
   * 证明：设慢指针走n长度后与快指针相遇，直线长度m，环长k
   * 由快指针一共比慢指针多走k长度可知，2n-m-(n-m)=k，即n=k
   * n=k => k-(n-m) = m
   *
   * time: O(n)
   * space: O(1)
   */
  public ListNode detectCycle1(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    boolean cycle = false;
    while (fast != null && fast.next != null && slow != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        cycle = true;
        break;
      }
    }

    if (!cycle) {
      return null;
    }

    ListNode cycleNode = head;
    while (slow != cycleNode) {
      slow = slow.next;
      cycleNode = cycleNode.next;
    }

    return cycleNode;
  }
}
