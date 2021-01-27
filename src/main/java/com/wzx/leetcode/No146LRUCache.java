package com.wzx.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/lru-cache/">https://leetcode.com/problems/lru-cache/</a>
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
   * 双端链表
   */
  private static class DoublyList {
    // 首尾哨兵
    private final Node head;
    private final Node tail;

    public DoublyList() {
      this.head = new Node(0, 0);
      this.tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
    }

    private void deleteNode(Node node) {
      // prev <-> node <-> next
      // prev <-> next
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private void add2Head(Node node) {
      // head <-> next
      // head <-> node <-> next
      head.next.prev = node;
      node.next = head.next;
      head.next = node;
      node.prev = head;
    }

    public void move2Head(Node node) {
      deleteNode(node);
      add2Head(node);
    }

    public Node popTail() {
      Node node = tail.prev;
      deleteNode(node);
      return node;
    }
  }

  /**
   * 在哈希表的基础上使用双端链表维护访问顺序
   */
  public static class LRUCache2 {
    private final Map<Integer, Node> map;
    private final DoublyList list;
    private final int capacity;

    public LRUCache2(int capacity) {
      map = new HashMap<>();
      list = new DoublyList();
      this.capacity = capacity;
    }

    public int get(int key) {
      if (!map.containsKey(key)) return -1;

      Node node = map.get(key);
      // 访问结点移到链表首部
      list.move2Head(node);
      return node.val;
    }

    public void put(int key, int value) {
      // 添加或更新结点
      Node node;
      if(map.containsKey(key)){
        node = map.get(key);
        node.val = value;
        // 更新结点移动到链表首部
        list.move2Head(node);
      }else{
        node = new Node(key, value);
        map.put(key, node);
        // 新增结点添加到链表首部
        list.add2Head(node);
      }
      // 删除多余尾部结点
      if (map.size() > capacity) {
        Node tail = list.popTail();
        map.remove(tail.key);
      }
    }
  }
}
