package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class No382LinkedListRandomNodeTest {

  private final ListNode node = ListNode.build(Arrays.asList(1, 2, 3, 4));

  @Test
  public void findTheDifference() {
    No382LinkedListRandomNode solution = new No382LinkedListRandomNode(node);
    double[] res = new double[4];
    for (int i = 0; i < 10000; i++) {
      res[solution.getRandom() - 1]++;
    }
    double prob1 = res[0] / 10000;
    double prob2 = res[1] / 10000;
    double prob3 = res[2] / 10000;
    double prob4 = res[3] / 10000;
    assertEquals(0.25, prob1, 0.01);
    assertEquals(0.25, prob2, 0.01);
    assertEquals(0.25, prob3, 0.01);
    assertEquals(0.25, prob4, 0.01);
  }
}