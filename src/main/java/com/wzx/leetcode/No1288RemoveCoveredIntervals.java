package com.wzx.leetcode;

import java.util.Arrays;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/remove-covered-intervals/">https://leetcode.com/problems/remove-covered-intervals/</a>
 */
public class No1288RemoveCoveredIntervals {

  /**
   * 先排序，再画图考虑多种情况
   * <p>
   * time: O(nlogn)
   * space: O(1)
   */
  public int removeCoveredIntervals(int[][] intervals) {
    // 起点升序，终点降序
    Arrays.sort(intervals, (i1, i2) -> {
      if (i1[0] != i2[0]) {
        return i1[0] - i2[0];
      } else {
        return i2[1] - i1[1];
      }
    });

    int dup = 0;
    int right = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];

      if (interval[0] >= right) {
        // cur           |----|
        // prev |------|
        right = interval[1];
      } else if (interval[1] > right) {
        // cur    |-------|
        // prev |-------|
        right = interval[1];
      } else {
        // cur    |----|
        // prev |--------|
        dup++;
      }
    }

    return intervals.length - dup;
  }
}
