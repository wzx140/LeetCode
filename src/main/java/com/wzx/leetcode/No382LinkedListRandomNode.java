package com.wzx.leetcode;

import com.wzx.entity.ListNode;

import java.util.Random;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-random-node/">https://leetcode.com/problems/linked-list-random-node/</a>
 * @author wzx
 */
public class No382LinkedListRandomNode {

  private final ListNode head;
  private final Random rand = new Random();

  public No382LinkedListRandomNode(ListNode head) {
    this.head = head;
  }

  /**
   * 水塘抽样
   *
   * time: O(n)
   * space: O(1)
   */
  public int getRandom() {
    int res = 0;
    int len = 0;
    ListNode node = head;
    while (node != null) {
      if (rand.nextInt(++len) < 1) {
        res = node.val;
      }
      node = node.next;
    }

    return res;
  }
}
