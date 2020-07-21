package com.wzx.leetcode;

import com.wzx.leetcode.No138CopyListWithRandomPointer.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class No138CopyListWithRandomPointerTest {

  Node node1 = null;
  Node node2 = null;
  Node node3 = null;

  @Before
  public void setUp() {
    node1 = Node.build(Arrays.asList(Arrays.asList(7, null), Arrays.asList(13, 0), Arrays.asList(11, 4), Arrays.asList(10, 2), Arrays.asList(1, 0)));
    node2 = Node.build(Arrays.asList(Arrays.asList(1, 1), Arrays.asList(2, 1)));
    node3 = Node.build(Arrays.asList(Arrays.asList(3, null), Arrays.asList(3, 0), Arrays.asList(3, null)));
  }

  @Test
  public void copyRandomList1() {
    No138CopyListWithRandomPointer solution = new No138CopyListWithRandomPointer();

    Node res1 = solution.copyRandomList1(node1);
    assertEquals(Arrays.asList(Arrays.asList(7, null),
            Arrays.asList(13, 0),
            Arrays.asList(11, 4),
            Arrays.asList(10, 2),
            Arrays.asList(1, 0)), res1.toArray());

    Node res2 = solution.copyRandomList1(node2);
    assertEquals(Arrays.asList(Arrays.asList(1, 1),
            Arrays.asList(2, 1)), res2.toArray());

    Node res3 = solution.copyRandomList1(node3);
    assertEquals(Arrays.asList(Arrays.asList(3, null),
            Arrays.asList(3, 0),
            Arrays.asList(3, null)), res3.toArray());

    assertNull(solution.copyRandomList1(null));
  }

  @Test
  public void copyRandomList2() {
    No138CopyListWithRandomPointer solution = new No138CopyListWithRandomPointer();

    Node res1 = solution.copyRandomList2(node1);
    assertEquals(Arrays.asList(Arrays.asList(7, null),
            Arrays.asList(13, 0),
            Arrays.asList(11, 4),
            Arrays.asList(10, 2),
            Arrays.asList(1, 0)), res1.toArray());

    Node res2 = solution.copyRandomList2(node2);
    assertEquals(Arrays.asList(Arrays.asList(1, 1),
            Arrays.asList(2, 1)), res2.toArray());

    Node res3 = solution.copyRandomList2(node3);
    assertEquals(Arrays.asList(Arrays.asList(3, null),
            Arrays.asList(3, 0),
            Arrays.asList(3, null)), res3.toArray());

    assertNull(solution.copyRandomList2(null));
  }

  @Test
  public void copyRandomList3() {
    No138CopyListWithRandomPointer solution = new No138CopyListWithRandomPointer();

    Node res1 = solution.copyRandomList3(node1);
    assertEquals(Arrays.asList(Arrays.asList(7, null),
            Arrays.asList(13, 0),
            Arrays.asList(11, 4),
            Arrays.asList(10, 2),
            Arrays.asList(1, 0)), res1.toArray());

    Node res2 = solution.copyRandomList3(node2);
    assertEquals(Arrays.asList(Arrays.asList(1, 1),
            Arrays.asList(2, 1)), res2.toArray());

    Node res3 = solution.copyRandomList3(node3);
    assertEquals(Arrays.asList(Arrays.asList(3, null),
            Arrays.asList(3, 0),
            Arrays.asList(3, null)), res3.toArray());

    assertNull(solution.copyRandomList3(null));
  }
}