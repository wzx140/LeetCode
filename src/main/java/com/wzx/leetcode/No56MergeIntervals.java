package com.wzx.leetcode;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/merge-intervals/">https://leetcode.com/problems/merge-intervals/</a>
 * @author wzx
 */
public class No56MergeIntervals {

  /**
   * 先排序，再画图考虑多种情况
   *
   * time: O(nlogn)
   * space: O(n)
   */
  public int[][] merge(int[][] intervals) {
    // 起点升序
    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

    List<int[]> res = new ArrayList<>();
    int left = intervals[0][0];
    int right = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[0] <= right) {
        // cur    |---|
        // prev |-------|

        // cur    |-------|
        // prev |-------|
        right = Math.max(interval[1], right);
      } else {
        // cur          |----|
        // sum |------|
        res.add(new int[]{left, right});
        left = interval[0];
        right = interval[1];
      }
    }
    res.add(new int[]{left, right});

    return res.toArray(new int[0][0]);
  }
}
