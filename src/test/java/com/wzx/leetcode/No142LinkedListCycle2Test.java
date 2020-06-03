package com.wzx.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.wzx.entity.ListNode;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class No142LinkedListCycle2Test {

  private final ListNode node1 = new ListNode();
  private final ListNode node2 = new ListNode();
  private final ListNode node3 = new ListNode();

  @Before
  public void setUp() {
    node1.build(Arrays.asList(3, 2, 0, -4));
    node1.next.next.next.next = node1.next;

    node2.build(Arrays.asList(1, 2));
    node2.next.next = node2;

    node3.val = 1;
  }

  @Test
  public void detectCycle1Test() {
    No142LinkedListCycle2 solution = new No142LinkedListCycle2();
    assertEquals(node1.next, solution.detectCycle1(node1));
    assertEquals(node2, solution.detectCycle1(node2));
    assertNull(solution.detectCycle1(node3));
  }
}