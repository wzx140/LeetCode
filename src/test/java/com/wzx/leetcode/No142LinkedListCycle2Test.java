package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class No142LinkedListCycle2Test {

  private ListNode node1 = null;
  private ListNode node2 = null;
  private ListNode node3 = null;

  @Before
  public void setUp() {
    node1 = ListNode.build(Arrays.asList(3, 2, 0, -4));
    node1.next.next.next.next = node1.next;

    node2 = ListNode.build(Arrays.asList(1, 2));
    node2.next.next = node2;

    node3 = ListNode.build(Collections.singletonList(1));
  }

  @Test
  public void detectCycle1Test() {
    No142LinkedListCycle2 solution = new No142LinkedListCycle2();
    assertEquals(node1.next, solution.detectCycle1(node1));
    assertEquals(node2, solution.detectCycle1(node2));
    assertNull(solution.detectCycle1(node3));
  }
}