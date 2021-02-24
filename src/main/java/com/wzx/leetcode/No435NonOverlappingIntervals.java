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
   * 1. 每次选出start最小的区间
   * 2. 去除与该区间重叠的区间
   * <p>
   * time: O(nlogn)
   * space: O(1)
   */
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) return 0;
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    int bound = intervals[0][1];
    int cnt = 0;
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[0] < bound) {
        // 重叠
        cnt++;
        bound = Math.min(bound, interval[1]);
      } else {
        // 不重叠
        bound = interval[1];
      }
    }

    return cnt;
  }
}
