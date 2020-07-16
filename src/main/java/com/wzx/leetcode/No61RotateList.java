package com.wzx.leetcode;

import com.wzx.entity.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/
 *
 * @author wzx
 */
public class No61RotateList {

    /**
     * 用中间数组暂存顺序
     * <p>
     * time: O(n)
     * space: O(n)
     */
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }

        int move = k % size;
        if (move == 0) {
            return head;
        }

        // 保持旋转后顺序的暂存数组
        ListNode[] tmp = new ListNode[size];
        node = head;
        for (int i = 0; i < size; i++) {
            int index = move + i;
            index = index >= size ? index - size : index;

            tmp[index] = node;
            node = node.next;
        }

        // 重建链表
        for (int i = 0; i < size - 1; i++) {
            tmp[i].next = tmp[i + 1];
        }
        tmp[size - 1].next = null;
        return tmp[0];
    }

    /**
     * 首尾相接成环，再确定头节点
     * <p>
     * time: O(n)
     * space: O(1)
     */
    public ListNode rotateRight2(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        int size = 1;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        node.next = head;

        int move = k % size;
        // size - 1 = tail + move
        int tail = size - move - 1;
        while (tail-- != 0) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;

        return res;
    }
}
