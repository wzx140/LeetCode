package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/design-linked-list/">https://leetcode.com/problems/design-linked-list/</a>
 * @author wzx
 */
public class No707DesignLinkedList {

  static class MyLinkedList {

    private static class ListNode {
      public int val;
      public ListNode next;
      public ListNode pre;

      public ListNode(int val) {
        this.val = val;
      }
    }

    private final ListNode head;
    private final ListNode tail;
    private int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
      head = new ListNode(-1);
      tail = new ListNode(-1);
      head.next = tail;
      tail.pre = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
      if (index < 0 || index >= size) return -1;

      return getCurNode(index).val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the
     * new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
      ListNode newNode = new ListNode(val);
      // head <--> newNode <--> head.next
      head.next.pre = newNode;
      newNode.next = head.next;
      head.next = newNode;
      newNode.pre = head;

      size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
      ListNode newNode = new ListNode(val);
      // tail.pre <--> newNode <--> tail
      tail.pre.next = newNode;
      newNode.pre = tail.pre;
      tail.pre = newNode;
      newNode.next = tail;

      size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the
     * length of linked list, the node will be appended to the end of linked list. If index is
     * greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
      if(index > size || index < 0) return;

      ListNode node = getCurNode(index);
      ListNode newNode = new ListNode(val);
      // node.pre <--> newNode <-> node
      newNode.pre = node.pre;
      node.pre.next = newNode;
      newNode.next = node;
      node.pre = newNode;

      size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
      if (index >= size || index < 0) return;

      ListNode node = getCurNode(index);
      // node.pre <--> node.next
      node.pre.next = node.next;
      node.next.pre = node.pre;

      size--;
    }

    /**
     * 根据index判断从head处遍历还是从tail处遍历
     */
    private ListNode getCurNode(int index) {
      ListNode node;
      if (index < size - index) {
        node = head;
        while (index-- >= 0) {
          node = node.next;
        }
      } else {
        node = tail;
        index = size - 1 - index;
        while (index-- >= 0) {
          node = node.pre;
        }
      }
      return node;
    }
  }
}
