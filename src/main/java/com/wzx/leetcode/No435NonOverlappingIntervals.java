package com.wzx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/non-overlapping-intervals/">https://leetcode.com/problems/non-overlapping-intervals/</a>
 */
public class No435NonOverlappingIntervals {

  /**
   * 贪心
   * 1. 每次选出end最小的区间
   * 2. 去除与该区间重叠的区间
   * <p>
   * time: O(nlogn)
   * space: O(1)
   */
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) return 0;
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

    int lastEnd = intervals[0][1];
    int cnt = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= lastEnd) {
        // 不重叠
        lastEnd = intervals[i][1];
      } else {
        // 重叠
        cnt++;
      }
    }

    return cnt;
  }
}
