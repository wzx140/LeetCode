package com.wzx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * @author wzx
 */
public class No416PartitionEqualSubsetSum {

  /**
   * 容量为sum/2的0-1背包问题
   * dp[n][i]: 前i个数是否可以组合成n
   * dp[n][i]=dp[n-nums[i]][i-1]||dp[n][i-1] 是否组合nums[i]
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if ((sum & 1) == 1) return false;
    int target = sum / 2;

    boolean[][] dp = new boolean[target + 1][nums.length + 1];
    // 边界条件
    for (int i = 0; i <= target; i++) {
      dp[i][0] = false;
    }
    for (int i = 1; i <= nums.length; i++) {
      dp[0][i] = true;
    }

    for (int n = 1; n <= target; n++) {
      for (int i = 1; i <= nums.length; i++) {
        if (n >= nums[i - 1]) {
          dp[n][i] = dp[n - nums[i - 1]][i - 1] || dp[n][i - 1];
        } else {
          dp[n][i] = dp[n][i - 1];
        }
      }
    }

    return dp[target][nums.length];
  }
}
