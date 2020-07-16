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

  public void build(List<Integer> data) {
    ListNode cur = null;
    ListNode prev = null;
    this.val = data.get(0);
    prev = this;
    for (int i = 1; i < data.size(); i++) {
      cur = new ListNode(data.get(i));
      prev.next = cur;
      prev = cur;
    }
  }

  public List<Integer> toArray() {
    List<Integer> res = new LinkedList<>();
    ListNode node = this;
    while (node != null) {
      res.add(node.val);
      node = node.next;
    }

    return res;
  }

  public void print() {
    ListNode node = this;
    StringBuilder sb = new StringBuilder();
    while (node != null) {
      sb.append(node.val).append(',');
      node = node.next;
    }
    sb.setLength(sb.length() - 1);
    System.out.println(sb.toString());
  }
}
