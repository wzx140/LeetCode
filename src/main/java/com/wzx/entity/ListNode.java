package com.wzx.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * 链表数据结构
 *
 * @author wzx
 */
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode build(List<Integer> data) {
    ListNode sentinel = new ListNode();
    ListNode pre = sentinel;
    for (int num : data) {
      ListNode node = new ListNode(num);
      pre.next = node;
      pre = node;
    }

    return sentinel.next;
  }

  public List<Integer> toList() {
    List<Integer> res = new LinkedList<>();
    ListNode node = this;
    while (node != null) {
      res.add(node.val);
      node = node.next;
    }

    return res;
  }

  @Override
  public String toString() {
    ListNode node = this;
    StringBuilder sb = new StringBuilder();
    while (node != null) {
      sb.append(node.val).append(',');
      node = node.next;
    }
    sb.setLength(sb.length() - 1);
    return sb.toString();
  }
}
