package com.wzx.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.wzx.common.Constant.RANDOM_SAMPLE_NUM;
import static com.wzx.leetcode.No710RandomPickWithBlacklist.*;
import static org.junit.Assert.*;

public class No710RandomPickWithBlacklistTest {

  @Test
  public void blackList() {
    Solution solution1 = new Solution(1, new int[0]);
    assertEquals(0, solution1.pick());
    assertEquals(0, solution1.pick());
    assertEquals(0, solution1.pick());

    Solution solution2 = new Solution(2, new int[0]);
    assertEquals(0, solution1.pick());
    assertEquals(0, solution1.pick());
    assertEquals(0, solution1.pick());
    Map<Integer, Integer> res = new HashMap<>();
    for (int i = 0; i < RANDOM_SAMPLE_NUM; i++) {
      res.merge(solution2.pick(), 1, Integer::sum);
    }
    double prob1 = (float) res.get(0) / RANDOM_SAMPLE_NUM;
    double prob2 = (float) res.get(1) / RANDOM_SAMPLE_NUM;
    assertEquals(0.5, prob1, 0.01);
    assertEquals(0.5, prob2, 0.01);

    Solution solution3 = new Solution(3, new int[]{1});
    assertEquals(0, solution1.pick());
    assertEquals(0, solution1.pick());
    assertEquals(0, solution1.pick());
    res = new HashMap<>();
    for (int i = 0; i < RANDOM_SAMPLE_NUM; i++) {
      res.merge(solution3.pick(), 1, Integer::sum);
    }
    prob1 = (float) res.get(0) / RANDOM_SAMPLE_NUM;
    prob2 = (float) res.get(2) / RANDOM_SAMPLE_NUM;
    assertEquals(0.5, prob1, 0.01);
    assertEquals(0.5, prob2, 0.01);

    Solution solution4 = new Solution(4, new int[]{2});
    assertEquals(0, solution1.pick());
    assertEquals(0, solution1.pick());
    assertEquals(0, solution1.pick());
    res = new HashMap<>();
    for (int i = 0; i < RANDOM_SAMPLE_NUM; i++) {
      res.merge(solution4.pick(), 1, Integer::sum);
    }
    prob1 = (float) res.get(0) / RANDOM_SAMPLE_NUM;
    prob2 = (float) res.get(1) / RANDOM_SAMPLE_NUM;
    double prob3 = (float) res.get(3) / RANDOM_SAMPLE_NUM;
    assertEquals(1 / 3., prob1, 0.01);
    assertEquals(1 / 3., prob2, 0.01);
    assertEquals(1 / 3., prob3, 0.01);
  }
}