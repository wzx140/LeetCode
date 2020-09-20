package com.wzx.leetcode;

import com.wzx.entity.ListNode;
import org.junit.Test;

import java.util.Arrays;

import static com.wzx.common.Constant.RANDOM_SAMPLE_NUM;
import static org.junit.Assert.assertEquals;

public class No382LinkedListRandomNodeTest {

  private final ListNode node = ListNode.build(Arrays.asList(1, 2, 3, 4));

  @Test
  public void findTheDifference() {
    No382LinkedListRandomNode solution = new No382LinkedListRandomNode(node);
    double[] res = new double[4];
    for (int i = 0; i < RANDOM_SAMPLE_NUM; i++) {
      res[solution.getRandom() - 1]++;
    }
    double prob1 = res[0] / RANDOM_SAMPLE_NUM;
    double prob2 = res[1] / RANDOM_SAMPLE_NUM;
    double prob3 = res[2] / RANDOM_SAMPLE_NUM;
    double prob4 = res[3] / RANDOM_SAMPLE_NUM;
    assertEquals(0.25, prob1, 0.01);
    assertEquals(0.25, prob2, 0.01);
    assertEquals(0.25, prob3, 0.01);
    assertEquals(0.25, prob4, 0.01);
  }
}