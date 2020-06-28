package com.wzx.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.wzx.entity.ListNode;
import java.util.Arrays;
import java.util.Collections;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class No160IntersectionOfTwoLinkedListsTest {

  private final ListNode nodeAHead = new ListNode();
  private final ListNode nodeBHead = new ListNode();
  private final ListNode nodeIntersection = new ListNode();

  @Test
  public void getIntersectionNode1Test() {
    No160IntersectionOfTwoLinkedLists solution = new No160IntersectionOfTwoLinkedLists();

    nodeAHead.build(Arrays.asList(4, 1));
    nodeBHead.build(Arrays.asList(5, 0, 1));
    nodeIntersection.build(Arrays.asList(8, 4, 5));
    nodeAHead.next.next = nodeIntersection;
    nodeBHead.next.next.next = nodeIntersection;
    assertEquals(nodeIntersection, solution.getIntersectionNode1(nodeAHead, nodeBHead));

    nodeAHead.build(Arrays.asList(0, 9, 1));
    nodeBHead.build(Collections.singletonList(3));
    nodeIntersection.next = null;
    nodeIntersection.build(Arrays.asList(2, 4));
    nodeAHead.next.next.next = nodeIntersection;
    nodeBHead.next = nodeIntersection;
    assertEquals(nodeIntersection, solution.getIntersectionNode1(nodeAHead, nodeBHead));

    nodeAHead.next = null;
    nodeBHead.next = null;
    nodeAHead.build(Arrays.asList(2, 6, 4));
    nodeBHead.build(Arrays.asList(1, 5));
    assertNull(solution.getIntersectionNode1(nodeAHead, nodeBHead));
  }

  @Test
  public void getIntersectionNode2Test() {
    No160IntersectionOfTwoLinkedLists solution = new No160IntersectionOfTwoLinkedLists();

    nodeAHead.build(Arrays.asList(4, 1));
    nodeBHead.build(Arrays.asList(5, 0, 1));
    nodeIntersection.build(Arrays.asList(8, 4, 5));
    nodeAHead.next.next = nodeIntersection;
    nodeBHead.next.next.next = nodeIntersection;
    assertEquals(nodeIntersection, solution.getIntersectionNode2(nodeAHead, nodeBHead));

    nodeAHead.build(Arrays.asList(0, 9, 1));
    nodeBHead.build(Collections.singletonList(3));
    nodeIntersection.next = null;
    nodeIntersection.build(Arrays.asList(2, 4));
    nodeAHead.next.next.next = nodeIntersection;
    nodeBHead.next = nodeIntersection;
    assertEquals(nodeIntersection, solution.getIntersectionNode2(nodeAHead, nodeBHead));

    nodeAHead.next = null;
    nodeBHead.next = null;
    nodeAHead.build(Arrays.asList(2, 6, 4));
    nodeBHead.build(Arrays.asList(1, 5));
    assertNull(solution.getIntersectionNode2(nodeAHead, nodeBHead));
  }
}