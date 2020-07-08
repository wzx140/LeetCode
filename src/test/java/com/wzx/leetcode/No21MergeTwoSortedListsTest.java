package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No21MergeTwoSortedListsTest {

  ListNode node1 = new ListNode();
  ListNode node2 = new ListNode();

  @Before
  public void setUp() {
    node1.build(Arrays.asList(1, 2, 4));
    node2.build(Arrays.asList(1, 3, 4));
  }

  @Test
  public void mergeTwoLists1() {
    No21MergeTwoSortedLists solution = new No21MergeTwoSortedLists();
    ListNode node = solution.mergeTwoLists1(node1, node2);
    assertEquals(1, node.val);
    assertEquals(1, node.next.val);
    assertEquals(2, node.next.next.val);
    assertEquals(3, node.next.next.next.val);
    assertEquals(4, node.next.next.next.next.val);
    assertEquals(4, node.next.next.next.next.next.val);

  }
}