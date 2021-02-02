package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/ugly-number-ii/">https://leetcode.com/problems/ugly-number-ii/</a>
 */
public class No264UglyNumberII {

  /**
   * 动态规划
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int nthUglyNumber(int n) {
    // dp[i]: 第i个丑数
    int[] dp = new int[n];
    dp[0] = 1;
    // dp中下一次需要乘2,3,5的位置
    // i2,i3,i5用于回溯到之前的状态
    int i2 = 0, i3 = 0, i5 = 0;

    for (int i = 1; i < n; i++) {
      // 优先累乘结果较小的因子
      dp[i] = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
      // 累乘较小因子x后，丑数ix+1为因子x下一次累乘的位置
      // 如果出现最小值相等的情况，会将所有满足条件的索引加1，防止出现重复的情况
      if (dp[i] == dp[i2] * 2) i2++;
      if (dp[i] == dp[i3] * 3) i3++;
      if (dp[i] == dp[i5] * 5) i5++;
    }

    return dp[n - 1];
  }
}
