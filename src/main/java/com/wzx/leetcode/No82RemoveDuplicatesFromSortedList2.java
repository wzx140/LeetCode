package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/</a>
 */
public class No82RemoveDuplicatesFromSortedList2 {

  /**
   * 快慢指针
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public ListNode deleteDuplicates1(ListNode head) {
    if (head == null) return null;
    // 哨兵处理头结点也被删除的情况
    ListNode sent = new ListNode(-101);
    sent.next = head;
    ListNode preSlow = sent, preFast = sent, slow = head, fast = head;
    while (fast != null) {
      // 前后都不相同才是唯一的结点
      if (fast.val != preFast.val
              && (fast.next == null || fast.val != fast.next.val)) {
        slow.val = fast.val;
        preSlow = slow;
        slow = slow.next;
      }
      preFast = fast;
      fast = fast.next;
    }
    // 处理尾结点
    preSlow.next = null;

    return sent.next;
  }
}
