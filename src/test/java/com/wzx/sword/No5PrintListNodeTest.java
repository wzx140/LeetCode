package com.wzx.sword;

import com.wzx.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class No5PrintListNodeTest {

  private final ListNode node1 = ListNode.build(Arrays.asList(1, 2, 3));
  private final List<Integer> res1 = Arrays.asList(3, 2, 1);
  private final ListNode node2 = ListNode.build(Collections.singletonList(1));
  private final List<Integer> res2 = Collections.singletonList(1);

  @Test
  public void printListFromTailToHead1() {
    assertEquals(res1, No5PrintListNode.printListFromTailToHead1(node1));
    assertEquals(res2, No5PrintListNode.printListFromTailToHead1(node2));
    assertEquals(new ArrayList<>(), No5PrintListNode.printListFromTailToHead1(null));
  }

  @Test
  public void printListFromTailToHead2() {
    assertEquals(res1, No5PrintListNode.printListFromTailToHead2(node1));
    assertEquals(res2, No5PrintListNode.printListFromTailToHead2(node2));
    assertEquals(new ArrayList<>(), No5PrintListNode.printListFromTailToHead2(null));
  }

  @Test
  public void printListFromTailToHead3() {
    assertEquals(res1, No5PrintListNode.printListFromTailToHead3(node1));
    assertEquals(res2, No5PrintListNode.printListFromTailToHead3(node2));
    assertEquals(new ArrayList<>(), No5PrintListNode.printListFromTailToHead3(null));
  }
}