package com.wzx.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">https://leetcode.com/problems/copy-list-with-random-pointer/</a>
 * @author wzx
 */
public class No138CopyListWithRandomPointer {

  /**
   * 将带随机指针的链表看成图(每个结点通过next和random和其他节点连接)，使用带备忘录的深搜
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public Node copyRandomList1(Node head) {
    return recursion(head, new HashMap<>());
  }

  private Node recursion(Node node, Map<Node, Node> memo){
    if(node == null) return null;
    if(memo.containsKey(node)) return memo.get(node);

    Node newNode = new Node(node.val);
    memo.put(node, newNode);
    newNode.next = recursion(node.next, memo);
    newNode.random = recursion(node.random, memo);
    return newNode;
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

  private Node cloneNode(Node node, Map<Node, Node> visit) {
    if (node == null) return null;
    if (visit.containsKey(node)) return visit.get(node);

    Node newNode = new Node(node.val);
    visit.put(node, newNode);
    return newNode;
  }

  /**
   * 将clone后的节点放在当前节点后面，newNode.random = node.random.next
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public Node copyRandomList3(Node head) {
    if (head == null) return null;
    // 复制结点
    Node node = head;
    while(node != null){
      Node newNode = new Node(node.val);
      // clone结点接到原结点后面
      Node nextNode = node.next;
      node.next = newNode;
      newNode.next = nextNode;
      // 遍历
      node = nextNode;
    }
    // 复制random
    node = head;
    while(node != null){
      Node newNode = node.next;
      Node randomNode = node.random;
      if(randomNode != null)  newNode.random = randomNode.next;

      node = node.next.next;
    }
    // 分开两个链表
    node = head;
    Node newHead = node.next;
    while(node != null){
      Node newNode = node.next;
      node.next = node.next.next;
      if(newNode.next != null) newNode.next = newNode.next.next;

      node = node.next;
    }
    return newHead;
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