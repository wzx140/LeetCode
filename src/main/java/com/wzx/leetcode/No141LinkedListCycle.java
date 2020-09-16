package com.wzx.leetcode;

import com.wzx.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * @author wzx
 */
public class No141LinkedListCycle {

  /**
   * time: O(n)
   * space: O(n)
   */
  public boolean hasCycle1(ListNode head) {
    Set<ListNode> nodeSet = new HashSet<>();

    while (head != null) {
      if (nodeSet.contains(head)) {
        return true;
      } else {
        nodeSet.add(head);
        head = head.next;
      }
    }

    return false;
  }

  /**
   * 快慢指针
   * 设总长为n，环长k，非环部分为n-k
   * 当慢指针刚进入环时，快指针已经在环中，迭代了n-k次
   * 快指针最慢需要k次迭代就能在环中追上慢指针，迭代了k次
   * 总共 n-k+k=n
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public boolean hasCycle2(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null && slow != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }

    return false;
  }
}
