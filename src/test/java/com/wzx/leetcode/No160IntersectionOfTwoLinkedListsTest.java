package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class No160IntersectionOfTwoLinkedListsTest {

    private ListNode nodeAHead1 = null;
    private ListNode nodeBHead1 = null;
    private ListNode nodeIntersection1 = null;

    private ListNode nodeAHead2 = null;
    private ListNode nodeBHead2 = null;
    private ListNode nodeIntersection2 = null;

    private ListNode nodeAHead3 = null;
    private ListNode nodeBHead3 = null;

    @Before
    public void setUp() {
        nodeAHead1 = ListNode.build(Arrays.asList(4, 1));
        nodeBHead1 = ListNode.build(Arrays.asList(5, 0, 1));
        nodeIntersection1 = ListNode.build(Arrays.asList(8, 4, 5));
        nodeAHead1.next.next = nodeIntersection1;
        nodeBHead1.next.next.next = nodeIntersection1;

        nodeAHead2 = ListNode.build(Arrays.asList(0, 9, 1));
        nodeBHead2 = ListNode.build(Collections.singletonList(3));
        nodeIntersection2 = ListNode.build(Arrays.asList(2, 4));
        nodeAHead2.next.next.next = nodeIntersection2;
        nodeBHead2.next = nodeIntersection2;

        nodeAHead3 = ListNode.build(Arrays.asList(2, 6, 4));
        nodeBHead3 = ListNode.build(Arrays.asList(1, 5));
    }

    @Test
    public void getIntersectionNode1Test() {
        No160IntersectionOfTwoLinkedLists solution = new No160IntersectionOfTwoLinkedLists();

        assertEquals(nodeIntersection1, solution.getIntersectionNode1(nodeAHead1, nodeBHead1));
        assertEquals(nodeIntersection2, solution.getIntersectionNode1(nodeAHead2, nodeBHead2));
        assertNull(solution.getIntersectionNode1(nodeAHead3, nodeBHead3));
    }

    @Test
    public void getIntersectionNode2Test() {
        No160IntersectionOfTwoLinkedLists solution = new No160IntersectionOfTwoLinkedLists();

        assertEquals(nodeIntersection1, solution.getIntersectionNode2(nodeAHead1, nodeBHead1));
        assertEquals(nodeIntersection2, solution.getIntersectionNode2(nodeAHead2, nodeBHead2));
        assertNull(solution.getIntersectionNode2(nodeAHead3, nodeBHead3));
    }
}