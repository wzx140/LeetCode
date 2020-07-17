package com.wzx.leetcode;

import com.wzx.entity.Node;

import java.util.Deque;
import java.util.LinkedList;

public class No430FlattenAMultilevelDoublyLinkedList {

    private Node flattenDfs(Node pre, Node cur) {
        if (cur == null) return pre;

        pre.next = cur;
        cur.prev = pre;
        Node next = cur.next;

        // 优先连接cur节点和child节点
        Node tail = flattenDfs(cur, cur.child);
        cur.child = null;

        // 最后将cur.next连到child子链表后
        return flattenDfs(tail, next);
    }

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
        flattenDfs(sentinel, head);

        head.prev = null;
        return head;
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
}
