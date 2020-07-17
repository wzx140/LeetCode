package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class No2AddTwoNumbersTest {

    private ListNode num11 = null;
    private ListNode num12 = null;
    private ListNode num21 = null;
    private ListNode num22 = null;

    @Before
    public void setUp() {
        num11 = ListNode.build(Arrays.asList(2, 4, 3));
        num12 = ListNode.build(Arrays.asList(5, 6, 4));
        num21 = ListNode.build(Collections.singletonList(5));
        num22 = ListNode.build(Collections.singletonList(5));
    }

    @Test
    public void addTwoNumbers() {
        No2AddTwoNumbers solution = new No2AddTwoNumbers();
        ListNode res = solution.addTwoNumbers(num11, num12);
        assertEquals(7, res.val);
        assertEquals(0, res.next.val);
        assertEquals(8, res.next.next.val);

        res = solution.addTwoNumbers(num21, num22);
        assertEquals(0, res.val);
        assertEquals(1, res.next.val);
    }
}