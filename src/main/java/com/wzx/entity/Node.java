package com.wzx.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * 多级双向链表
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public static Node build(List<Integer> data) {
        Node sentinel = new Node();
        Node pre = sentinel;

        int offset = 0;
        int subSize = 0;
        for (int i = 0; i < data.size(); i++) {
            Integer num = data.get(i);

            if (num == null) {
                offset++;
                continue;
            }

            Node node = new Node(num);
            if (offset != 0) {
                int prevStep = subSize - offset;
                while (prevStep-- > 0) pre = pre.prev;
                pre.child = node;

                offset = 0;
                subSize = 0;
            } else {
                pre.next = node;
                node.prev = pre;
            }
            subSize++;
            pre = node;
        }
        sentinel.next.prev = null;

        return sentinel.next;
    }

    public List<Integer> toArray() {
        List<Integer> res = new LinkedList<>();
        Node node = this;
        while (node != null) {
            res.add(node.val);
            node = node.next;
        }

        return res;
    }
}
