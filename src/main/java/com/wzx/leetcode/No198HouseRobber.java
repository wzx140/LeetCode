package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/">https://leetcode.com/problems/house-robber/</a>
 * @author wzx
 */
public class No198HouseRobber {

  /**
   * 动态规划
   * dp[i]: 偷窃房屋[0, i]的最大利润
   * 递推: dp[i] = max(nums[i] + dp[i - 2], dp[i - 1]), 第i个房屋偷与不偷
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int rob(int[] nums) {
    int[] dp = new int[nums.length + 2];
    for (int i = 2; i < nums.length + 2; i++) {
      dp[i] = Math.max(nums[i - 2] + dp[i - 2], dp[i - 1]);
    }

    return dp[nums.length + 1];
  }
}
