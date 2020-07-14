package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No445AddTwoNumbers2Test {

  private final ListNode num11 = new ListNode();
  private final ListNode num12 = new ListNode();

  @Before
  public void setUp() {
    num11.build(Arrays.asList(7, 2, 4, 3));
    num12.build(Arrays.asList(5, 6, 4));
  }

  @Test
  public void addTwoNumbers() {
    No445AddTwoNumbers2 solution = new No445AddTwoNumbers2();
    ListNode res = solution.addTwoNumbers(num11, num12);
    assertEquals(7, res.val);
    assertEquals(8, res.next.val);
    assertEquals(0, res.next.next.val);
    assertEquals(7, res.next.next.next.val);
  }
}