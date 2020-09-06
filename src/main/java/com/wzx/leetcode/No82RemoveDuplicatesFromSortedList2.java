package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author wzx
 */
public class No82RemoveDuplicatesFromSortedList2 {

  /**
   * 快慢指针
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public ListNode deleteDuplicates1(ListNode head) {
    if (null == head || null == head.next) return head;

    // 当前对比位置
    ListNode fast = head;
    ListNode preFast = null;
    // 当前存储位置
    ListNode preSlow = null;
    ListNode slow = head;

    while (fast != null) {
      // 前后都不相同才是唯一的结点
      if ((null == preFast || fast.val != preFast.val)
              && (null == fast.next || fast.val != fast.next.val)) {

        slow.val = fast.val;
        preSlow = slow;
        slow = slow.next;
      }
      preFast = fast;
      fast = fast.next;
    }

    // 去除多余的结点
    if (preSlow != null) {
      preSlow.next = null;
    } else {
      return null;
    }

    return head;
  }
}
