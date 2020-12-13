package com.wzx.leetcode;

import com.wzx.leetcode.No430FlattenAMultilevelDoublyLinkedList.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.wzx.testUtil.AssertListNode.assertDoublyLinkedList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class No430FlattenAMultilevelDoublyLinkedListTest {

    private Node node1 = null;
    private Node node2 = null;
    private Node node3 = null;

    @Before
    public void setUp() {
        node1 = Node.build(Arrays.asList(1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12));
        node2 = Node.build(Arrays.asList(1, 2, null, 3));
        node3 = Node.build(Arrays.asList(4201, null, 1937, null, 3203));
    }

    @Test
    public void flatten1() {
      No430FlattenAMultilevelDoublyLinkedList solution = new No430FlattenAMultilevelDoublyLinkedList();

      Node res1 = solution.flatten1(node1);
      assertDoublyLinkedList(res1);
      assertEquals(Arrays.asList(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6), res1.toArray());

      Node res2 = solution.flatten1(node2);
      assertDoublyLinkedList(res2);
      assertEquals(Arrays.asList(1, 3, 2), res2.toArray());

      Node res3 = solution.flatten1(node3);
      assertDoublyLinkedList(res3);
      assertEquals(Arrays.asList(4201, 1937, 3203), res3.toArray());

      assertNull(solution.flatten1(null));
    }

    @Test
    public void flatten2() {
      No430FlattenAMultilevelDoublyLinkedList solution = new No430FlattenAMultilevelDoublyLinkedList();

      Node res1 = solution.flatten2(node1);
      assertDoublyLinkedList(res1);
      assertEquals(Arrays.asList(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6), res1.toArray());

      Node res2 = solution.flatten2(node2);
      assertDoublyLinkedList(res2);
      assertEquals(Arrays.asList(1, 3, 2), res2.toArray());

      Node res3 = solution.flatten2(node3);
      assertDoublyLinkedList(res3);
      assertEquals(Arrays.asList(4201, 1937, 3203), res3.toArray());

      assertNull(solution.flatten2(null));
    }
}