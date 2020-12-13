package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No61RotateListTest {

    private ListNode node1 = null;
    private ListNode node2 = null;

    @Before
    public void setUp() {
        node1 = ListNode.build(Arrays.asList(1, 2, 3, 4, 5));
        node2 = ListNode.build(Arrays.asList(0, 1, 2));
    }

    @Test
    public void rotateRight1() {
        No61RotateList solution = new No61RotateList();
        ListNode res1 = solution.rotateRight1(node1, 2);
        assertEquals(Arrays.asList(4, 5, 1, 2, 3), res1.toList());

        ListNode res2 = solution.rotateRight1(node2, 4);
        assertEquals(Arrays.asList(2, 0, 1), res2.toList());
    }

    @Test
    public void rotateRight2() {
        No61RotateList solution = new No61RotateList();
        ListNode res1 = solution.rotateRight2(node1, 2);
        assertEquals(Arrays.asList(4, 5, 1, 2, 3), res1.toList());

        ListNode res2 = solution.rotateRight2(node2, 4);
        assertEquals(Arrays.asList(2, 0, 1), res2.toList());
    }
}