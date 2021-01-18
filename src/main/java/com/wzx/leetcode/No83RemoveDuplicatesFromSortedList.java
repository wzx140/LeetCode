package com.wzx.leetcode;

import com.wzx.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">https://leetcode.com/problems/remove-duplicates-from-sorted-list/</a>
 */
public class No83RemoveDuplicatesFromSortedList {

  /**
   * 哈希表
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public static ListNode deleteDuplicates1(ListNode head) {
    Set<Integer> numSet = new HashSet<>();

    // 哨兵
    ListNode sent = new ListNode();
    sent.next = head;
    ListNode pre = sent;
    while (head != null) {
      if (numSet.contains(head.val)) {
        // 删除结点
        pre.next = head.next;
      } else {
        numSet.add(head.val);
        pre = head;
      }
      head = head.next;
    }

    return sent.next;
  }

  /**
   * 快慢指针
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public static ListNode deleteDuplicates2(ListNode head) {
    if (head == null) return null;
    ListNode preSlow = head, preFast = head, slow = head.next, fast = head.next;
    while (fast != null) {
      if (fast.val != preFast.val) {
        slow.val = fast.val;
        preSlow = slow;
        slow = slow.next;
      }
      preFast = fast;
      fast = fast.next;
    }
    // 处理尾结点
    preSlow.next = null;

    return head;
  }
}
