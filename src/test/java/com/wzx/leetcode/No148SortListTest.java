package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No148SortListTest {

  private final ListNode l1 = ListNode.build(Arrays.asList(4, 2, 1, 3));
  private final ListNode res1 = ListNode.build(Arrays.asList(1, 2, 3, 4));
  private final ListNode l2 = ListNode.build(Arrays.asList(-1, 5, 3, 4, 0));
  private final ListNode res2 = ListNode.build(Arrays.asList(-1, 0, 3, 4, 5));

  @Test
  public void sortList() {
    No148SortList solution = new No148SortList();
    assertEquals(res1.toList(), solution.sortList(l1).toList());
    assertEquals(res2.toList(), solution.sortList(l2).toList());
  }
}