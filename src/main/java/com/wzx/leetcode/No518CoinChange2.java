package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/coin-change-2/">https://leetcode.com/problems/coin-change-2/</a>
 */
public class No518CoinChange2 {

  /**
   * dp[n][i]: 使用前i个硬币组合成n的方法数
   * 递推公式: dp[n][i]=dp[n-nums[i]][i]+dp[n][i-1]  不取与取nums[i]硬币
   * 注意和322对比, 322求的是最少硬币个数, 使用一维数组会重复遍历重复组合, 但是由于记录最小硬币数, 所以对结果没有影响
   * 这里求的是组合数, 使用一维数组会产生重复的组合eg:(1, 2), (2, 1)
   * <p>
   * time: O(S*n)
   * space: O(S*n)
   */
  public int change(int amount, int[] coins) {
    int[][] dp = new int[amount + 1][coins.length + 1];
    // 边界条件
    // amount=0, 什么都不取即可完成目标
    for (int i = 0; i <= coins.length; i++) {
      dp[0][i] = 1;
    }
    // 没有零钱, 则不可能完成目标
    for (int i = 1; i <= amount; i++) {
      dp[i][0] = 0;
    }

    for (int n = 1; n <= amount; n++) {
      for (int i = 1; i <= coins.length; i++) {
        if (n >= coins[i - 1]) {
          dp[n][i] = dp[n - coins[i - 1]][i] + dp[n][i - 1];
        } else {
          dp[n][i] = dp[n][i - 1];
        }
      }
    }

    return dp[amount][coins.length];
  }
}
