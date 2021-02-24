package com.wzx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/</a>
 */
public class No452MinimumNumberOfArrowsToBurstBalloons {

  /**
   * 贪心
   * No435NonOverlappingIntervals求的是最大不重叠区间数，本题求的是最小不重叠区间数
   * <p>
   * time: O(nlogn)
   * space: O(1)
   */
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;
    Arrays.sort(points, Comparator.comparingInt(point -> point[0]));

    // 统计最小不重叠气球数
    int cnt = 1;
    int bound = points[0][1];
    for (int i = 1; i < points.length; i++) {
      int[] point = points[i];
      if (point[0] > bound) {
        // 不重叠
        cnt++;
        bound = point[1];
      } else {
        bound = Math.min(point[1], bound);
      }
    }

    // 最小不重叠气球数即最小射箭数
    return cnt;
  }
}
