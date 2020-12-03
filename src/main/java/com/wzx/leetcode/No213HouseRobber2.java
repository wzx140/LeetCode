package com.wzx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber-ii/
 *
 * @author wzx
 */
public class No213HouseRobber2 {

  /**
   * 动态规划, 在198. house robber的基础上改进
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];

    int[] dp = new int[nums.length + 2];
    // 最后一个房间不偷
    int rob1 = dp(nums, dp, 0, nums.length - 2);
    // 第一个房间不偷
    int rob2 = dp(nums, dp, 1, nums.length - 1);

    return Math.max(rob1, rob2);
  }

  private int dp(int[] nums, int[] dp, int start, int end) {
    Arrays.fill(dp, start, end + 2, 0);
    for (int i = end; i >= start; i--) {
      dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
    }
    return dp[start];
  }
}
