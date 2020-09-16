package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class No141LinkedListCycleTest {

    private ListNode node1 = null;
    private ListNode node2 = null;
    private ListNode node3 = null;

    @Before
    public void setUp() {
        node1 = ListNode.build(Arrays.asList(3, 2, 0, 4));
        node1.next.next.next.next = node1.next;

        node2 = ListNode.build(Arrays.asList(1, 2));
        node2.next = node2;

        node3 = ListNode.build(Collections.singletonList(1));
    }

    @Test
    public void hasCycle1Test() {
        No141LinkedListCycle solution = new No141LinkedListCycle();
        assertTrue(solution.hasCycle1(node1));
        assertTrue(solution.hasCycle1(node2));
        assertFalse(solution.hasCycle1(node3));
    }

    @Test
    public void hasCycle2Test() {
        No141LinkedListCycle solution = new No141LinkedListCycle();
        assertTrue(solution.hasCycle2(node1));
        assertTrue(solution.hasCycle2(node2));
        assertFalse(solution.hasCycle2(node3));
    }
}