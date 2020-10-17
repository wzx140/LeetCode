package com.wzx.sword;

import com.wzx.entity.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;


public class No6PrintListNodeTest {

  private final ListNode node1 = ListNode.build(Arrays.asList(1, 2, 3));
  private final int[] res1 = {3, 2, 1};
  private final ListNode node2 = ListNode.build(Collections.singletonList(1));
  private final int[] res2 = {1};
  private final int[] nullArray = {};

  @Test
  public void reversePrint1() {
    No6PrintListNode solution = new No6PrintListNode();
    assertArrayEquals(res1, solution.reversePrint1(node1));
    assertArrayEquals(res2, solution.reversePrint1(node2));
    assertArrayEquals(nullArray, solution.reversePrint1(null));
  }

  @Test
  public void reversePrint2() {
    No6PrintListNode solution = new No6PrintListNode();
    assertArrayEquals(res1, solution.reversePrint2(node1));
    assertArrayEquals(res2, solution.reversePrint2(node2));
    assertArrayEquals(nullArray, solution.reversePrint2(null));
  }

  @Test
  public void reversePrint3() {
    No6PrintListNode solution = new No6PrintListNode();
    assertArrayEquals(res1, solution.reversePrint3(node1));
    assertArrayEquals(res2, solution.reversePrint3(node2));
    assertArrayEquals(nullArray, solution.reversePrint3(null));
  }
}