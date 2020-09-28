package com.wzx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
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
    if (intervals == null) return null;
    if (intervals.length == 0) return new int[0][0];

    // 起点升序
    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

    List<int[]> res = new LinkedList<>();
    res.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] last = res.get(res.size() - 1);
      int[] interval = intervals[i];
      if (interval[0] <= last[1]) {
        // cur   |---|
        // sum |-------|

        // cur |---|
        // sum |------|

        // cur |--------|
        // sum |------|

        // cur   |-------|
        // sum |-------|

        // cur        |----|
        // sum |------|
        last[1] = Math.max(interval[1], last[1]);
      } else {
        // cur          |----|
        // sum |------|
        res.add(interval);
      }
    }

    return res.toArray(new int[res.size()][]);
  }
}
