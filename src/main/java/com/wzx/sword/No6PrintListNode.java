package com.wzx.sword;

import com.wzx.entity.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author wzx
 */
public class No6PrintListNode {

  /**
   * 放入栈中
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] reversePrint1(ListNode head) {
    Deque<Integer> stack = new ArrayDeque<>();

    while (head != null) {
      stack.push(head.val);
      head = head.next;
    }
    int[] res = new int[stack.size()];
    int index = 0;
    while (stack.peek() != null) {
      res[index++] = stack.pop();
    }
    return res;
  }

  /**
   * 反转链表
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] reversePrint2(ListNode head) {
    if (null == head) return new int[0];

    int size = 0;
    ListNode sent = new ListNode(0);
    sent.next = head;
    ListNode cur = head;
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

    int[] res = new int[size + 1];
    head = sent.next;
    int index = 0;
    while (head != null) {
      res[index++] = head.val;
      head = head.next;
    }
    return res;
  }

  /**
   * 递归
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] reversePrint3(ListNode head) {
    List<Integer> res = new ArrayList<>();
    recursion(head, res);

    return res.stream().mapToInt(i -> i).toArray();
  }

  private void recursion(ListNode node, List<Integer> list) {
    if (node != null) {
      recursion(node.next, list);
      list.add(node.val);
    }
  }
}
