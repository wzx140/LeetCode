package com.wzx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * @author wzx
 */
public class No452MinimumNumberOfArrowsToBurstBalloons {

  /**
   * 贪心, 做法与No435NonOverlappingIntervals一致
   * <p>
   * time: O(nlogn)
   * space: O(1)
   */
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;
    Arrays.sort(points, Comparator.comparingInt(point -> point[1]));

    // 统计最小不重叠气球数
    int cnt = 1;
    int lastEnd = points[0][1];
    for (int i = 1; i < points.length; i++) {
      int start = points[i][0];
      int end = points[i][1];
      if (start > lastEnd) {
        // 不重叠
        lastEnd = end;
        cnt++;
      }
    }

    // 最小不重叠气球数即最小射箭数
    return cnt;
  }
}
