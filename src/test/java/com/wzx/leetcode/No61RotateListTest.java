package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class No61RotateListTest {

    ListNode node1 = new ListNode();
    ListNode node2 = new ListNode();

    @Before
    public void setUp() {
        node1.build(Arrays.asList(1, 2, 3, 4, 5));
        node2.build(Arrays.asList(0, 1, 2));
    }

    @Test
    public void rotateRight1() {
        No61RotateList solution = new No61RotateList();
        ListNode res1 = solution.rotateRight1(node1, 2);
        assertEquals(Arrays.asList(4, 5, 1, 2, 3), res1.toArray());

        ListNode res2 = solution.rotateRight1(node2, 4);
        assertEquals(Arrays.asList(2, 0, 1), res2.toArray());
    }

    @Test
    public void rotateRight2() {
        No61RotateList solution = new No61RotateList();
        ListNode res1 = solution.rotateRight2(node1, 2);
        assertEquals(Arrays.asList(4, 5, 1, 2, 3), res1.toArray());

        ListNode res2 = solution.rotateRight2(node2, 4);
        assertEquals(Arrays.asList(2, 0, 1), res2.toArray());
    }
}