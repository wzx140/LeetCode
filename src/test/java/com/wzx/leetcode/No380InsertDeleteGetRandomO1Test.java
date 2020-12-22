package com.wzx.leetcode;

import org.junit.Test;

import static com.wzx.common.Constant.RANDOM_SAMPLE_NUM;
import static com.wzx.leetcode.No380InsertDeleteGetRandomO1.*;
import static org.junit.Assert.*;

public class No380InsertDeleteGetRandomO1Test {
  @Test
  public void RandomizedSet() {
    RandomizedSet randomizedSet = new RandomizedSet();
    assertTrue(randomizedSet.insert(1));
    assertFalse(randomizedSet.remove(2));
    assertTrue(randomizedSet.insert(2));

    int[] res = new int[2];
    for (int i = 0; i < RANDOM_SAMPLE_NUM; i++) {
      res[randomizedSet.getRandom() - 1]++;
    }
    double prob1 = (float) res[0] / RANDOM_SAMPLE_NUM;
    double prob2 = (float) res[1] / RANDOM_SAMPLE_NUM;
    assertEquals(0.5, prob1, 0.01);
    assertEquals(0.5, prob2, 0.01);

    assertTrue(randomizedSet.remove(1));
    assertFalse(randomizedSet.insert(2));
    for (int i = 0; i < RANDOM_SAMPLE_NUM; i++) {
      assertEquals(2, randomizedSet.getRandom());
    }
  }
}