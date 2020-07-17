package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No445AddTwoNumbers2Test {

  private ListNode num1 = null;
  private ListNode num2 = null;

  @Before
  public void setUp() {
    num1 = ListNode.build(Arrays.asList(7, 2, 4, 3));
    num2 = ListNode.build(Arrays.asList(5, 6, 4));
  }

  @Test
  public void addTwoNumbers() {
    No445AddTwoNumbers2 solution = new No445AddTwoNumbers2();

    ListNode res = solution.addTwoNumbers(num1, num2);
    assertEquals(Arrays.asList(7, 8, 0, 7), res.toArray());
  }
}