package com.wzx.leetcode;

import java.util.Arrays;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/partition-equal-subset-sum/">https://leetcode.com/problems/partition-equal-subset-sum/</a>
 */
public class No416PartitionEqualSubsetSum {

  /**
   * 容量为 sum/2 的 0-1 背包问题
   * <p>
   * time: O(S*n)
   * space: O(S)
   */
  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 != 0) {
      return false;
    }

    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int num : nums) {
      for (int j = target; j >= num; j--) {
        dp[j] |= dp[j - num];
      }
    }
    return dp[target];
  }


}
