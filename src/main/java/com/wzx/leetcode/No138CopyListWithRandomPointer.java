package com.wzx.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * @author wzx
 */
public class No138CopyListWithRandomPointer {

  /**
   * 将带随机指针的链表看成图，带缓存的dfs，递归
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public Node copyRandomList1(Node head) {
    if (head == null) return null;
    Map<Node, Node> visit = new HashMap<>();

    return dfs(head, visit);
  }

  /**
   * 按照next顺序遍历链表，保存已经clone过的节点
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public Node copyRandomList2(Node head) {
    if (head == null) return null;
    Map<Node, Node> visit = new HashMap<>();
    Node newHead = new Node(head.val);
    visit.put(head, newHead);

    Node node = head;
    Node newNode = newHead;
    while (node != null) {
      newNode.random = cloneNode(node.random, visit);
      newNode.next = cloneNode(node.next, visit);

      newNode = newNode.next;
      node = node.next;
    }

    return newHead;
  }

  /**
   * 将clone后的节点放在当前节点后面，newNode.random = node.random.next
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public Node copyRandomList3(Node head) {
    if (head == null) return null;

    Node node = head;
    Node newNode = null;
    // clone并放到下一个
    while (node != null) {
      newNode = new Node(node.val);
      Node next = node.next;
      newNode.next = next;
      node.next = newNode;

      node = next;
    }

    node = head;
    // 确定random
    while (node != null) {
      node.next.random = node.random != null ? node.random.next : null;
      node = node.next.next;
    }

    Node origin = head;
    Node clone = head.next;
    Node newHead = clone;
    // 分开链表
    while (origin != null) {
      origin.next = origin.next.next;
      clone.next = clone.next != null ? clone.next.next : null;

      origin = origin.next;
      clone = clone.next;
    }

    return newHead;
  }

  private Node dfs(Node node, Map<Node, Node> visit) {
    Node newNode = null;
    if (visit.containsKey(node)) {
      newNode = visit.get(node);
    } else {
      newNode = new Node(node.val);
      visit.put(node, newNode);

      if (node.next != null) {
        newNode.next = dfs(node.next, visit);
      }

      if (node.random != null) {
        newNode.random = dfs(node.random, visit);
      }
    }

    return newNode;
  }

  private Node cloneNode(Node node, Map<Node, Node> visit) {
    if (node == null) return null;
    if (visit.containsKey(node)) return visit.get(node);

    Node newNode = new Node(node.val);
    visit.put(node, newNode);
    return newNode;
  }

  public static class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }

    public static Node build(List<List<Integer>> data) {
      Node pre = new Node(0);
      List<Node> nodes = new ArrayList<>(data.size());
      for (List<Integer> pointer : data) {
        int num = pointer.get(0);
        Node node = new Node(num);
        nodes.add(node);
        pre.next = node;
        pre = node;
      }

      for (int i = 0; i < data.size(); i++) {
        Integer next = data.get(i).get(1);
        if (next != null) {
          nodes.get(i).random = nodes.get(next);
        }
      }

      return nodes.get(0);
    }

    public List<List<Integer>> toArray() {
      List<Node> nodes = new ArrayList<>();
      Node node = this;
      while (node != null) {
        nodes.add(node);
        node = node.next;
      }

      return nodes.stream().map(x -> {
        Integer index = nodes.indexOf(x.random);
        if (index == -1) {
          index = null;
        }
        return Arrays.asList(x.val, index);
      }).collect(Collectors.toList());
    }
  }
}