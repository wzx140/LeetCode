package com.wzx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @see <a href="https://leetcode.com/problems/russian-doll-envelopes/">https://leetcode.com/problems/russian-doll-envelopes/</a>
 * @author wzx
 */
public class No354RussianDollEnvelopes {

  /**
   * 按照width升序排列, 取得height的最长增长子序列, 做法同No300LongestIncreasingSubsequence
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes.length == 0) return 0;
    Arrays.sort(envelopes, Comparator.comparingInt(e -> e[0]));

    int[] dp = new int[envelopes.length];
    Arrays.fill(dp, 1);

    int res = 1;
    for (int i = 0; i < envelopes.length; i++) {
      for (int j = 0; j < i; j++) {
        if (envelopes[i][0] != envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        res = Math.max(res, dp[i]);
      }
    }

    return res;
  }
}
