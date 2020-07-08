package com.wzx.leetcode;

import org.junit.Test;

import com.wzx.leetcode.No707DesignLinkedList.MyLinkedList;

import static org.junit.Assert.*;

public class No707DesignLinkedListTest {

  @Test
  public void testLinkedList1() {
    MyLinkedList linkedList = new MyLinkedList();
    linkedList.addAtHead(1);
    linkedList.addAtTail(3);
    linkedList.addAtIndex(1, 2);
    assertEquals(2, linkedList.get(1));
    linkedList.deleteAtIndex(1);
    assertEquals(3, linkedList.get(1));
  }

  @Test
  public void testLinkedList2() {
    MyLinkedList linkedList = new MyLinkedList();
    linkedList.addAtHead(7);
    linkedList.addAtHead(2);
    linkedList.addAtHead(1);
    linkedList.addAtIndex(3, 0);
    linkedList.deleteAtIndex(2);
    linkedList.addAtHead(6);
    linkedList.addAtTail(4);
    assertEquals(4, linkedList.get(4));
    linkedList.addAtHead(4);
    linkedList.addAtIndex(5, 0);
    linkedList.addAtHead(6);
  }
}