package com.wzx.sword;

import com.wzx.entity.ListNode;

import java.util.*;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/</a>
 */
public class No6PrintListNode {

  /**
   * 放入栈中
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] reversePrint1(ListNode head) {
    Deque<Integer> stack = new LinkedList<>();

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
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;

      size++;
    }

    int[] res = new int[size];
    ListNode node = pre;
    int index = 0;
    while (node != null) {
      res[index++] = node.val;
      node = node.next;
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
    if (node == null) return;

    recursion(node.next, list);
    list.add(node.val);
  }
}
