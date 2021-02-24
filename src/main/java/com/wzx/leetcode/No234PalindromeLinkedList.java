package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list/">https://leetcode.com/problems/palindrome-linked-list/</a>
 * @author wzx
 */
public class No234PalindromeLinkedList {

  /**
   * 反转后半链表, 迭代比较
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public boolean isPalindrome(ListNode head) {
    // 快慢指针找中点
    ListNode center;
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // 链表为奇数
    //        slow      fast
    // 1->2->  3  ->4->  5  ->null
    if (fast != null) {
      center = slow.next;
    }
    // 链表为偶数
    //        slow       fast
    // 1->2->  3  ->4->  null
    else {
      center = slow;
    }

    // 从中点之后反转
    // cur->next
    ListNode cur = center;
    ListNode pre = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }

    // 比较回文
    ListNode left = head, right = pre;
    while (left != null && right != null) {
      if (left.val != right.val) return false;
      left = left.next;
      right = right.next;
    }
    return true;
  }
}
