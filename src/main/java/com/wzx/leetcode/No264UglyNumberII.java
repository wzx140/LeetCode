package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * @author wzx
 */
public class No264UglyNumberII {

  /**
   * 动态规划
   *
   * time: O(n)
   * space: O(n)
   */
  public int nthUglyNumber(int n) {
    int[] dp = new int[n];
    dp[0] = 1;
    // dp中上一次乘2,3,5的位置
    int i2 = 0, i3 = 0, i5 = 0;
    // dp中的当前位置
    int index = 1;

    while (index < n) {
      // 优先累乘结果较小的因子。i2,i3,i5用于回溯到之前的状态，防止遗漏因子组合
      dp[index] = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
      // 如果出现最小值相等的情况，会将所有满足条件的索引加1，防止出现重复的情况
      if (dp[index] == dp[i2] * 2) i2++;
      if (dp[index] == dp[i3] * 3) i3++;
      if (dp[index] == dp[i5] * 5) i5++;
      index++;
    }

    return dp[n - 1];
  }
}
