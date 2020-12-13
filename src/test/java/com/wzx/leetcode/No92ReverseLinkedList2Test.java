package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No92ReverseLinkedList2Test {

    private ListNode node = null;

    @Before
    public void setUp() {
        node = ListNode.build(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void reverseBetweenTest() {
        No92ReverseLinkedList2 solution = new No92ReverseLinkedList2();
        ListNode head = solution.reverseBetween(this.node, 2, 4);

        assertEquals(Arrays.asList(1, 4, 3, 2, 5), head.toList());
    }
}