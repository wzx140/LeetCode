package com.wzx.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/target-sum/">https://leetcode.com/problems/target-sum/</a>
 * @author wzx
 */
public class No494TargetSum {

  /**
   * sum(+num) - sum(-num) = target
   * 2sum(+num) = target + sum(num)
   * sum(+num) = (target + sum(num))/2
   * 转化为背包问题
   * <p>
   * time: O(S*n)
   * space: O(S*n)
   */
  public int findTargetSumWays(int[] nums, int S) {
    // 转化为背包问题
    int sum = Arrays.stream(nums).sum();
    if (sum < S) return 0;
    int target = S + sum;
    if ((target & 1) == 1) return 0;
    target /= 2;

    // 初始化
    int[][] dp = new int[target + 1][nums.length + 1];
    for (int i = 0; i <= target; i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i <= nums.length; i++) {
      dp[0][i] = 1;
    }

    // 递推
    // 从0开始, 处理nums中有0的特殊情况
    for (int n = 0; n <= target; n++) {
      for (int i = 1; i <= nums.length; i++) {
        dp[n][i] = dp[n][i - 1]
                + (n >= nums[i - 1] ? dp[n - nums[i - 1]][i - 1] : 0);
      }
    }

    return dp[target][nums.length];
  }
}
