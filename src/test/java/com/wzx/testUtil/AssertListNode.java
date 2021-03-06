package com.wzx.testUtil;

import com.wzx.leetcode.No430FlattenAMultilevelDoublyLinkedList.Node;

import static org.junit.Assert.assertEquals;

public class AssertListNode {

  /**
   * 检查双向链表的指针连接
   */
  public static void assertDoublyLinkedList(Node head) {
    Node pre = null;
    while (head != null) {
      assertEquals(pre, head.prev);
      pre = head;
      head = head.next;
    }
  }
}
