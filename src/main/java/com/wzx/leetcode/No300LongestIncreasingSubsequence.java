package com.wzx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * @author wzx
 */
public class No300LongestIncreasingSubsequence {

  /**
   * dp[i]: 以第i个元素结尾的最长增长子序列
   * 递推公式: if nums[i]<nums[j]: dp[i] = dp[j]+1
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    // 每个元素自身都能组成增长子序列
    Arrays.fill(dp, 1);

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }

    return Arrays.stream(dp).max().orElse(0);
  }
}
