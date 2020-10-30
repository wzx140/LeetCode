package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author wzx
 */
public class No121BestTimeToBuyAndSellStock {

  /**
   * 股票问题动态规划统一模板
   *
   * dp[i][k][state]: i当前天数, k当前最多进行的交易次数, state当前是否持有股票, 值为当前收益
   * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+price[i])
   * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-price[i])
   */

  /**
   * 只能买卖一次, 不需要保持剩余买卖次数的k位
   * dp[i][k][0] = max(dp[i-1][1][0], dp[i-1][1][1]+price[i]) = max(dp[i-1][0], dp[i-1][1]+price[i])
   * dp[i][k][1] = max(dp[i-1][1][1], dp[i-1][0][0]-price[i]) = max(dp[i-1][1], -price[i])
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int maxProfit1(int[] prices) {
    int[][] dp = new int[prices.length + 1][2];
    // 边界条件, 开市前一天, 哨兵
    dp[0][0] = 0;
    dp[0][1] = Integer.MIN_VALUE;

    for (int i = 1; i <= prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
      dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
    }

    return dp[prices.length][0];
  }

  /**
   * 滚动数组优化
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int maxProfit2(int[] prices) {
    // 开市前, 哨兵
    int dp_i_1 = Integer.MIN_VALUE;
    int dp_i_0 = 0;

    for (int price : prices) {
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
      dp_i_1 = Math.max(dp_i_1, -price);
    }

    return dp_i_0;
  }
}
