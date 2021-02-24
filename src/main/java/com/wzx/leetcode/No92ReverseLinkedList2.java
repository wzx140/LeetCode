package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/">https://leetcode.com/problems/reverse-linked-list-ii/</a>
 */
public class No92ReverseLinkedList2 {

  /**
   * time: O(n)
   * space: O(1)
   */
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode sent = new ListNode();
    sent.next = head;
    // 找到left结点和left结点的前一个结点
    ListNode preLeftNode = sent;
    for (int i = 0; i < left - 1; i++) {
      preLeftNode = preLeftNode.next;
    }
    ListNode leftNode = preLeftNode.next;
    // 找到right结点和right结点的后一个结点
    ListNode rightNode = leftNode;
    for (int i = 0; i < right - left; i++) {
      rightNode = rightNode.next;
    }
    ListNode postRightNode = rightNode.next;
    // 反转left结点和right结点之间的结点
    ListNode pre = preLeftNode;
    ListNode node = leftNode;
    while (pre != rightNode) {
      ListNode next = node.next;
      node.next = pre;
      pre = node;
      node = next;
    }
    // 处理首末结点
    preLeftNode.next = rightNode;
    leftNode.next = postRightNode;

    return sent.next;
  }

}
