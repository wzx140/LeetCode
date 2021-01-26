package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/4sum-ii/">https://leetcode.com/problems/4sum-ii/</a>
 * @author wzx
 */
public class No454FourSum2 {

  /**
   * 哈希表
   *
   * time: O(n^2)
   * space: O(n^2)
   */
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> ABMap = new HashMap<>();
    int res = 0;

    for (int num1 : A) {
      for (int num2 : B) {
        ABMap.merge(num1 + num2, 1, Integer::sum);
      }
    }

    for (int num3 : C) {
      for (int num4 : D) {
        res += ABMap.getOrDefault(-(num3 + num4), 0);
      }
    }

    return res;
  }
}
