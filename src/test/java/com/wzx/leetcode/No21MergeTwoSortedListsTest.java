package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No21MergeTwoSortedListsTest {

    private ListNode node1 = null;
    private ListNode node2 = null;

    @Before
    public void setUp() {
        node1 = ListNode.build(Arrays.asList(1, 2, 4));
        node2 = ListNode.build(Arrays.asList(1, 3, 4));
    }

    @Test
    public void mergeTwoLists1() {
        No21MergeTwoSortedLists solution = new No21MergeTwoSortedLists();
        ListNode node = solution.mergeTwoLists1(node1, node2);
        assertEquals(Arrays.asList(1, 1, 2, 3, 4, 4), node.toArray());
    }
}