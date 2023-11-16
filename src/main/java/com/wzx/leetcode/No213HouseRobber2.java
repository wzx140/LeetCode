package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/house-robber-ii/">https://leetcode.com/problems/house-robber-ii/</a>
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

    // 第一个房间偷
    int rob1 = helper(nums, 2, nums.length - 2) + nums[0];
    // 第一个房间不偷
    int rob2 = helper(nums, 1, nums.length - 1);

    return Math.max(rob1, rob2);
  }

  private int helper(int[] nums, int start, int end) {
    int n = end - start + 1;
    int[] dp = new int[n + 2];
    for (int i = 2; i <= n + 1; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2 + start]);
    }

    return dp[n + 1];
  }
}
