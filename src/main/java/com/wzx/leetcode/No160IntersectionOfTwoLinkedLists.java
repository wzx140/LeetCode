package com.wzx.leetcode;

import com.wzx.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">https://leetcode.com/problems/intersection-of-two-linked-lists/</a>
 * @author wzx
 */
public class No160IntersectionOfTwoLinkedLists {

  /**
   * 哈希表
   *
   * time: O(n+m)
   * space: O(n)
   */
  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    Set<ListNode> listSet = new HashSet<>();
    while (headA != null) {
      listSet.add(headA);
      headA = headA.next;
    }

    while (headB != null) {
      if (listSet.contains(headB)) {
        return headB;
      }
      headB = headB.next;
    }
    return null;
  }

  /**
   * 双指针，从整体上来看，两个指针分别将两组链表都跑一遍，就能找到交叉点
   * <p>
   * time: O(m+n)
   * space: O(1)
   */
  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    ListNode node1 = headA;
    ListNode node2 = headB;

    // 在循环中，node1从headA遍历到headB，node2从headB遍历到headA
    // 如果没有交叉点则在末尾的null处相等并跳出循环
    while (node1 != node2) {
      node1 = node1 == null ? headB : node1.next;
      node2 = node2 == null ? headA : node2.next;
    }

    return node2;
  }
}
