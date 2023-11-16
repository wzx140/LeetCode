package com.wzx.leetcode;

import java.util.Arrays;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/target-sum/">https://leetcode.com/problems/target-sum/</a>
 */
public class No494TargetSum {

  /**
   * 转化为0-1背包问题
   * <p>
   * time: O(S*n)
   * space: O(S)
   */
  public int findTargetSumWays(int[] nums, int target) {
    // A1 - A2 = target
    // A1 + A2 = sum
    // A1 = (target + sum) / 2
    int sum = Arrays.stream(nums).sum();
    if ((target + sum) % 2 != 0) {
      return 0;
    }
    int goal = (target + sum) / 2;
    if (goal < 0) {
      return 0;
    }

    int[] dp = new int[goal + 1];
    dp[0] = 1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = goal; j >= nums[i]; j--) {
        dp[j] = dp[j] + dp[j - nums[i]];
      }
    }

    return dp[goal];
  }
}
