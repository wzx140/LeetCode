package com.wzx.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/coin-change/">https://leetcode.com/problems/coin-change/</a>
 */
public class No322CoinChange {

  /**
   * 自顶向下的递归, 使用数组作为memo会超时
   * <p>
   * time: O(s*n) s:amount, n:number of coins
   * space: O(n)
   */
  public int coinChange1(int[] coins, int amount) {
    Map<Integer, Integer> memo = new HashMap<>();
    return recursion(coins, amount, memo);
  }

  private int recursion(int[] coins, int amount, Map<Integer, Integer> memo) {
    if (amount == 0) return 0;
    if (memo.containsKey(amount)) return memo.get(amount);

    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (coin <= amount) {
        int res = recursion(coins, amount - coin, memo);
        if (res != -1) {
          min = Math.min(min, res + 1);
        }
      }
    }

    // 更新备忘录
    memo.put(amount, min == Integer.MAX_VALUE ? -1 : min);
    return memo.get(amount);
  }

  /**
   * 自顶向上的动态规划
   * dp[i]: i元的最小硬币数
   * dp[i] = min (dp[i-coin] for coin in coins)
   * <p>
   * time: O(s*n) s:amount, n:number of coins
   * space: O(n)
   */
  public int coinChange2(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }
}
