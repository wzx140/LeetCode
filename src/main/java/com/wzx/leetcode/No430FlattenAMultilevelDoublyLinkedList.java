package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/">https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/</a>
 */
public class No430FlattenAMultilevelDoublyLinkedList {

    /**
     * 递归
     * <p>
     * time:O(n)
     * space:O(n)
     */
    public Node flatten1(Node head) {
        if (head == null) return null;

        Node sentinel = new Node();
        sentinel.next = head;
        head.prev = sentinel;
        recursion(sentinel, head);

        head.prev = null;
        return head;
    }

    /**
     * 双向连接pre和cur并展开cur.child
     */
    private Node recursion(Node pre, Node cur) {
        if (cur == null) return pre;
        // 双向连接pre和cur
        pre.next = cur;
        cur.prev = pre;
        Node next = cur.next;
        // 连接cur和child
        Node tail = recursion(cur, cur.child);
        cur.child = null;
        // 将cur.next连到child子链表后
        return recursion(tail, next);
    }

    /**
     * 迭代
     * time:O(n)
     * space:O(n)
     */
    public Node flatten2(Node head) {
        if (head == null) return null;

        Deque<Node> stack = new LinkedList<>();

        Node pre = new Node();
        pre.next = head;
        Node cur = head;

        while (cur != null || !stack.isEmpty()) {

            if (cur == null) {
                cur = stack.pop();
                pre.next = cur;
                cur.prev = pre;

            } else if (cur.child != null) {
                // 优先连接cur和child，将cur.next缓存起来
                if (cur.next != null) stack.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }

            pre = cur;
            cur = cur.next;
        }

        head.prev = null;
        return head;
    }

    /**
     * 多级双向链表
     */
    public static class Node {
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
            for (Integer num : data) {
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
}
