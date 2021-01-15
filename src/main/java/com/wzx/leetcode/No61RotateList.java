package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/rotate-list/">https://leetcode.com/problems/rotate-list/</a>
 */
public class No61RotateList {

  /**
   * 直接轮转
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public ListNode rotateRight1(ListNode head, int k) {
    if (head == null) return null;
    // 计算长度
    int size = 1;
    ListNode tail = head;
    while (tail.next != null) {
      size++;
      tail = tail.next;
    }
    // 防止重复轮转
    k %= size;
    // 定位到旋转起始的前一个结点
    ListNode preHead = head;
    for (int i = 0; i < size - k - 1; i++) {
      preHead = preHead.next;
    }
    // 轮转
    tail.next = head;
    head = preHead.next;
    preHead.next = null;

    return head;
  }

  /**
   * 首尾相接成环，再确定头节点
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public ListNode rotateRight2(ListNode head, int k) {
    if (head == null) return null;
    // 计算长度
    int size = 1;
    ListNode tail = head;
    while (tail.next != null) {
      size++;
      tail = tail.next;
    }
    // 首尾相接
    tail.next = head;
    // 防止重复轮转
    k %= size;
    // 定位到旋转起始的前一个结点
    ListNode preHead = head;
    for (int i = 0; i < size - k - 1; i++) {
      preHead = preHead.next;
    }
    // 断开
    head = preHead.next;
    preHead.next = null;

    return head;
  }
}
