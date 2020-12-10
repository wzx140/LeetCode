package com.wzx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * @author wzx
 */
public class No354RussianDollEnvelopes {

  /**
   * 按照width升序排列, 相同的width按照height降序排列(防止选择相同width的信封), 取得height的LIS
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes,
            (en1, en2) -> {
              if (en1[0] == en2[0]) {
                return Integer.compare(en2[1], en1[1]);
              } else {
                return Integer.compare(en1[0], en2[0]);
              }
            });

    int[] dp = new int[envelopes.length];
    Arrays.fill(dp, 1);

    for (int i = 0; i < envelopes.length; i++) {
      for (int j = 0; j < i; j++) {
        if (envelopes[i][1] > envelopes[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }

    return Arrays.stream(dp).max().orElse(0);
  }
}
