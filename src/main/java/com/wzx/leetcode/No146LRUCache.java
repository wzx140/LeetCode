package com.wzx.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * @author wzx
 */
public class No146LRUCache {

  /**
   * 继承LinkedHashMap实现
   */
  public static class LRUCache1 extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache1(int capacity) {
      super(capacity, 1f, true);
      this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
      return size() > this.capacity;
    }

    public int get(int key) {
      return getOrDefault(key, -1);
    }
  }

  /**
   * 双端链表结点
   */
  private static class Node {
    public Node prev = null;
    public Node next = null;
    public final int key;
    public int val;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  /**
   * 在哈希表的基础上使用双端链表维护访问顺序
   */
  public static class LRUCache2 {

    // --- doubly linked list ---------------------------------------------------------------------
    // 首尾哨兵
    private final Node head;
    private final Node tail;

    private void deleteNode(Node node) {
      // prev <-> node <-> next
      // prev <-> next
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private void addNodeNext2Head(Node node) {
      // head <-> next
      // head <-> node <-> next
      head.next.prev = node;
      node.next = head.next;
      head.next = node;
      node.prev = head;
    }

    private void moveNode2Head(Node node) {
      deleteNode(node);
      addNodeNext2Head(node);
    }

    private Node popTail() {
      Node node = tail.prev;
      deleteNode(node);
      return node;
    }

    // --- hashmap --------------------------------------------------------------------------------
    private final Map<Integer, Node> map;
    private int size = 0;
    private final int capacity;

    public LRUCache2(int capacity) {
      // 取threshold正好为capacity
      map = new HashMap<>(capacity,1f);
      this.capacity = capacity;
      this.head  = new Node(0, 0);
      this.tail= new Node(0, 0);
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      Node node = map.get(key);
      if (node == null) return -1;
      moveNode2Head(node);
      return node.val;
    }

    public void put(int key, int value) {
      Node node = map.get(key);
      if (node != null) {
        node.val = value;
        moveNode2Head(node);
      } else {
        Node newNode = new Node(key, value);
        // 先删除，再添加，避免扩容
        if (size == capacity) {
          Node tail = popTail();
          map.remove(tail.key);
          size--;
        }
        map.put(key, newNode);
        addNodeNext2Head(newNode);
        size++;
      }
    }
  }
}
