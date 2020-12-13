package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No83RemoveDuplicatesFromSortedListTest {

  ListNode node1 = null;

  @Before
  public void setUp() {
    node1 = ListNode.build(Arrays.asList(1, 2, 3, 3, 4, 4, 5));
  }

  @Test
  public void deleteDuplication1() {
    assertEquals(Arrays.asList(1, 2, 3, 4, 5), No83RemoveDuplicatesFromSortedList.deleteDuplicates1(node1).toList());
  }

  @Test
  public void deleteDuplication2() {
    assertEquals(Arrays.asList(1, 2, 3, 4, 5), No83RemoveDuplicatesFromSortedList.deleteDuplicates2(node1).toList());
  }
}