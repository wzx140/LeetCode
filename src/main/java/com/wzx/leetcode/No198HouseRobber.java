package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/">https://leetcode.com/problems/house-robber/</a>
 * @author wzx
 */
public class No198HouseRobber {

  /**
   * 动态规划
   * dp[i]: 偷窃房屋[i, n]的最大利润
   * 递推: dp[i] = max(nums[i] + dp[i + 2], dp[i + 1]), 第i个房屋偷与不偷
   *
   * time: O(n)
   * space: O(n)
   */
  public int rob(int[] nums) {
    int[] dp = new int[nums.length + 2];
    for (int i = nums.length - 1; i >= 0; i--) {
      dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
    }

    return dp[0];
  }
}
