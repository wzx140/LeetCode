package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class No2AddTwoNumbersTest {

    private final ListNode num11 = new ListNode();
    private final ListNode num12 = new ListNode();
    private final ListNode num21 = new ListNode();
    private final ListNode num22 = new ListNode();

    @Before
    public void setUp() {
        num11.build(Arrays.asList(2, 4, 3));
        num12.build(Arrays.asList(5, 6, 4));
        num21.build(Collections.singletonList(5));
        num22.build(Collections.singletonList(5));
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