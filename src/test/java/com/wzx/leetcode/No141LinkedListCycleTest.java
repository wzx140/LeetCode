package com.wzx.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.wzx.entity.ListNode;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

public class No141LinkedListCycleTest {

  private final ListNode node1 = new ListNode();
  private final ListNode node2 = new ListNode();
  private final ListNode node3 = new ListNode();

  @Before
  public void setUp() {
    node1.build(Arrays.asList(3, 2, 0, 4));
    node1.next.next.next.next = node1.next;

    this.node2.build(Arrays.asList(1,2));
    node2.next = node2;
    this.node3.build(Collections.singletonList(1));
  }

  @Test
  public void hasCycle1Test() {
    No141LinkedListCycle solution = new No141LinkedListCycle();
    assertTrue(solution.hasCycle1(node1));
    assertTrue(solution.hasCycle1(node2));
    assertFalse(solution.hasCycle1(node3));
  }
}