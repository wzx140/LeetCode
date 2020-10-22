package com.wzx.sword;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * @author wzx
 */
public class No57NSum {

  /**
   * 滑动窗口
   *
   * time: O(n)
   * space: O(1)
   */
  public int[][] findContinuousSequence(int target) {
    List<int[]> res = new ArrayList<>();
    int left = 1, right = 2;
    while (left < right) {
      // 求和公式
      int sum = (left + right) * (right - left + 1) / 2;
      if (sum > target) {
        // 窗口右移
        left++;
      } else if (sum < target) {
        // 增大窗口
        right++;
      } else {
        res.add(IntStream.rangeClosed(left, right).toArray());
        left++;
      }
    }

    return res.toArray(new int[res.size()][]);
  }
}
