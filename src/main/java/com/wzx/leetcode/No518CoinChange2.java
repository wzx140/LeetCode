package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/coin-change-2/">https://leetcode.com/problems/coin-change-2/</a>
 */
public class No518CoinChange2 {

  /**
   * 完全背包
   * <p>
   * time: O(S*n)
   * space: O(S)
   */
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int j = coin; j <= amount; j++) {
        dp[j] = dp[j] + dp[j - coin];
      }
    }

    return dp[amount];
  }
}
