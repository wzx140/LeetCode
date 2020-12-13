package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No19RemoveNthNodeFromEndOfListTest {

  private ListNode list = null;
  private final ListNode res = ListNode.build(Arrays.asList(1, 2, 3, 5));

  @Before
  public void setUp() {
    list = ListNode.build(Arrays.asList(1, 2, 3, 4, 5));
  }

  @Test
  public void removeNthFromEnd() {
    No19RemoveNthNodeFromEndOfList solution = new No19RemoveNthNodeFromEndOfList();
    ListNode resList = solution.removeNthFromEnd(list, 2);
    assertEquals(res.toList(), resList.toList());
  }
}