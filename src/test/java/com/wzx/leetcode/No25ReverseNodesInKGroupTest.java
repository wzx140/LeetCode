package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class No25ReverseNodesInKGroupTest {

  private final ListNode node1 = ListNode.build(Arrays.asList(1, 2, 3, 4, 5));
  private final List<Integer> res1 = Arrays.asList(2, 1, 4, 3, 5);
  private final ListNode node2 = ListNode.build(Arrays.asList(1, 2, 3, 4, 5));
  private final List<Integer> res2 = Arrays.asList(3, 2, 1, 4, 5);
  private final ListNode node3 = ListNode.build(Arrays.asList(1, 2, 3, 4, 5));
  private final List<Integer> res3 = Arrays.asList(1, 2, 3, 4, 5);
  private final ListNode node4 = ListNode.build(Collections.singletonList(1));
  private final List<Integer> res4 = Collections.singletonList(1);

  @Test
  public void reverseKGroup() {
    No25ReverseNodesInKGroup solution = new No25ReverseNodesInKGroup();
    assertEquals(res1, solution.reverseKGroup(node1, 2).toList());
    assertEquals(res2, solution.reverseKGroup(node2, 3).toList());
    assertEquals(res3, solution.reverseKGroup(node3, 1).toList());
    assertEquals(res4, solution.reverseKGroup(node4, 1).toList());
  }
}