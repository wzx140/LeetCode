package com.wzx.leetcode;

import com.wzx.entity.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 *
 * @author wzx
 */
public class No445AddTwoNumbers2 {

  /**
   * 用栈保存两个链表，就可以逆序取出元素
   * <p>
   * time: O(max(m, n))
   * space: O(m+n)
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new ArrayDeque<>();
    while (l1 != null) {
      stack1.push(l1.val);
      l1 = l1.next;
    }
    while (l2 != null) {
      stack2.push(l2.val);
      l2 = l2.next;
    }

    ListNode head = null;
    int carry = 0;

    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      int value1 = stack1.isEmpty() ? 0 : stack1.pop();
      int value2 = stack2.isEmpty() ? 0 : stack2.pop();
      int res = value1 + value2 + carry;

      ListNode newNode = new ListNode(res % 10);
      carry = res / 10;
      newNode.next = head;
      head = newNode;
    }
    if (carry > 0) {
      ListNode newNode = new ListNode(carry);
      newNode.next = head;
      head = newNode;
    }

    return head;
  }
}
