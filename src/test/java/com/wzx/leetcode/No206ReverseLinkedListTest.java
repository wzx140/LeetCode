package com.wzx.leetcode;


import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No206ReverseLinkedListTest {

  private ListNode node = null;

  @Before
  public void setUp() {
    node = ListNode.build(Arrays.asList(1, 2, 3, 4, 5));
  }

  @Test
  public void reverseList1Test() {
    No206ReverseLinkedList solution = new No206ReverseLinkedList();

    ListNode head = solution.reverseList1(this.node);
    assertEquals(Arrays.asList(5, 4, 3, 2, 1), head.toList());
  }

}
