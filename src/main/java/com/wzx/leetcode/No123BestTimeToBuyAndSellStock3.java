package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/ *
 *
 * @author wzx
 */
public class No123BestTimeToBuyAndSellStock3 {

  /**
   * 股票问题动态规划统一模板
   *
   * dp[i][k][state]: i当前天数, k当前最多进行的交易次数, state当前是否持有股票, 值为当前收益
   * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+price[i])
   * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-price[i])
   */

  /**
   * 动态规划
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int maxProfit1(int[] prices) {
    int[][][] dp = new int[prices.length + 1][3][2];
    // 边界条件, 开市前一天, 哨兵
    dp[0][2][0] = 0;
    dp[0][2][1] = Integer.MIN_VALUE;
    dp[0][1][1] = Integer.MIN_VALUE;
    dp[0][0][1] = Integer.MIN_VALUE;

    for (int i = 1; i <= prices.length; i++) {
      // k=0已经不允许交易, 所以没有迭代的必要
      for (int k = 1; k < 3; k++) {
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
      }
    }

    return dp[prices.length][2][0];
  }

  /**
   * 滚动数组
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int maxProfit2(int[] prices) {
    // 开市前一天, 哨兵
    int dp_i_1_0 = 0;
    int dp_i_2_0 = 0;
    int dp_i_1_1 = Integer.MIN_VALUE;
    int dp_i_2_1 = Integer.MIN_VALUE;

    for (int price : prices) {
      dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + price);
      // dp_i_0_0表示未交易未持有, 所以收益一定是0
      dp_i_1_1 = Math.max(dp_i_1_1, -price);
      dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + price);
      dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - price);
    }

    return dp_i_2_0;
  }
}
