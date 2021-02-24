package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/">https://leetcode.com/problems/linked-list-cycle-ii/</a>
 */
public class No142LinkedListCycle2 {

  /**
   * 快慢指针，快指针和慢指针相遇时，新慢指针从起点出发，就慢指针从当前位置出发，相遇点就是环的起点
   * 证明：画一下图分析, 链表总长n, 环长l, 环起点到相遇点k
   * 由快指针比慢指针多走两倍可知，2(n-l+k)=n+k => n+k=2l
   * 带入慢指针走的长度可知 n-l+k=2l-l=l, 所以慢指针一共走过了环长的路程, 所以起点到环起点的长度为l-k即相遇点到环起点的长度
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    boolean cycle = false;
    while (fast != null && fast.next != null && slow != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        cycle = true;
        break;
      }
    }

    if (!cycle) {
      return null;
    }

    ListNode cycleNode = head;
    while (slow != cycleNode) {
      slow = slow.next;
      cycleNode = cycleNode.next;
    }

    return cycleNode;
  }
}
