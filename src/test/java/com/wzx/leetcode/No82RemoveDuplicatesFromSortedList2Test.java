package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No82RemoveDuplicatesFromSortedList2Test {

  private ListNode list1 = null;
  private ListNode res1 = ListNode.build(Arrays.asList(1, 2, 5));
  private ListNode list2 = null;
  private ListNode res2 = ListNode.build(Arrays.asList(2, 3));

  @Before
  public void setUp() {
    list1 = ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4, 5));
    list2 = ListNode.build(Arrays.asList(1, 1, 1, 2, 3));
  }

  @Test
  public void deleteDuplicates1() {
    No82RemoveDuplicatesFromSortedList2 solution = new No82RemoveDuplicatesFromSortedList2();
    ListNode node1 = solution.deleteDuplicates1(list1);
    assertEquals(res1.toArray(), node1.toArray());
    ListNode node2 = solution.deleteDuplicates1(list2);
    assertEquals(res2.toArray(), node2.toArray());
  }
}