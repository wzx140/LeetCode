package com.wzx.sword;

import com.wzx.entity.ListNode;

import java.util.*;

public class No5PrintListNode {

  /**
   * 放入栈中
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
    Deque<Integer> stack = new ArrayDeque<>();

    while (listNode != null) {
      stack.push(listNode.val);
      listNode = listNode.next;
    }
    ArrayList<Integer> res = new ArrayList<>(stack.size());
    while (stack.peek() != null) {
      res.add(stack.pop());
    }
    return res;
  }

  /**
   * 反转链表
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
    if (null == listNode) return new ArrayList<>();

    int size = 0;
    ListNode sent = new ListNode(0);
    sent.next = listNode;
    ListNode cur = listNode;
    // 头插法，反转链表
    // sent->x->cur->next(curHead)->y
    // sent->next(curHead)->x->cur->y
    while (cur.next != null) {
      ListNode curHead = cur.next;
      cur.next = curHead.next;
      curHead.next = sent.next;
      sent.next = curHead;

      size++;
    }

    ArrayList<Integer> res = new ArrayList<>(size + 1);
    listNode = sent.next;
    while (listNode != null) {
      res.add(listNode.val);
      listNode = listNode.next;
    }
    return res;
  }

  /**
   * 递归
   *
   * time: O(n)
   * space: O(n)
   */
  public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
    ArrayList<Integer> res = new ArrayList<>();
    recursion(listNode, res);

    return res;
  }
  private static void recursion(ListNode node, ArrayList<Integer> list) {
    if (node != null) {
      recursion(node.next, list);
      list.add(node.val);
    }
  }
}
