package com.wzx.leetcode;

import com.wzx.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author wzx
 */
public class No83RemoveDuplicatesFromSortedList {

  /**
   * 哈希表
   *
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
   *
   * time: O(n)
   * space: O(1)
   */
  public static ListNode deleteDuplicates2(ListNode head) {
    if (null == head || null == head.next) return head;

    // 存储指针
    ListNode store = head;
    ListNode pre = head;
    // 遍历指针
    ListNode cur = head.next;
    while (cur != null) {
      // 从第二个元素开始值不相等则在存储指针位置赋值
      if (cur.val != pre.val){
        store = store.next;
        store.val = cur.val;
      }
      cur = cur.next;
      pre = pre.next;
    }
    store.next = null;

    return head;
  }
}
