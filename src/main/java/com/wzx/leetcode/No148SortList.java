package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/sort-list/">https://leetcode.com/problems/sort-list/</a>
 */
public class No148SortList {

  /**
   * 归并排序
   *
   * time: O(nlogn)
   * space: O(logn)
   */
  public ListNode sortList(ListNode head) {
    return sort(head, null);
  }

  private ListNode sort(ListNode head, ListNode tail) {
    if (head == null) return null;
    if (head.next == tail) {
      head.next = null;
      return head;
    }
    // 快慢指针找到中点
    ListNode fast = head, slow = head;
    while (fast.next != tail && fast.next.next != tail) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode middle = slow.next;
    ListNode list1 = sort(head, middle);
    ListNode list2 = sort(middle, tail);
    return merge(list1, list2);
  }

  /**
   * 同No21MergeTwoSortedLists
   */
  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode node = head;
    while (l1 != null || l2 != null) {
      if (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
          node.next = l2;
          l2 = l2.next;
        } else {
          node.next = l1;
          l1 = l1.next;
        }
      } else if (l1 != null) {
        node.next = l1;
        l1 = l1.next;
      } else {
        node.next = l2;
        l2 = l2.next;
      }

      node = node.next;
    }

    return head.next;
  }
}
