package com.wzx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-covered-intervals/
 *
 * @author wzx
 */
public class No1288RemoveCoveredIntervals {

  /**
   * 先排序，再画图考虑多种情况
   *
   * time: O(nlogn)
   * space: O(1)
   */
  public int removeCoveredIntervals(int[][] intervals) {
    if (intervals == null) return 0;

    // 起点升序，终点降序
    Arrays.sort(intervals,
            (interval1, interval2) ->
                    interval1[0] != interval2[0] ? interval1[0] - interval2[0] : interval2[1] - interval1[1]);

    int dup = 0;
    int left = intervals[0][0];
    int right = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[1] <= right) {
        // cur   |----|
        // sum |--------|

        // cur   |---|
        // sum |-----|

        // cur |---|
        // sum |---|
        dup++;
      } else if (interval[0] > right) {
        // cur          |----|
        // sum |------|
        left = interval[0];
        right = interval[1];
      } else {
        // cur   |-------|
        // sum |-------|

        // cur |-----|
        // sum |---|
        right = interval[1];
      }
    }

    return intervals.length - dup;
  }
}
