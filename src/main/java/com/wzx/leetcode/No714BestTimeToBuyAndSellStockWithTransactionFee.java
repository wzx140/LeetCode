package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/</a>
 * @author wzx
 */
public class No714BestTimeToBuyAndSellStockWithTransactionFee {

  /**
   * 股票问题动态规划统一模板
   *
   * dp[i][k][state]: i当前天数, k当前最多进行的交易次数, state当前是否持有股票, 值为当前收益
   * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+price[i])
   * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-price[i])
   */

  /**
   * 在122. Best Time to Buy and Sell Stock II的基础上增加了交易费用
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int maxProfit1(int[] prices, int fee) {
    int[][] dp = new int[prices.length + 1][2];
    // 边界条件, 开市前一天, 哨兵
    dp[0][0] = 0;
    dp[0][1] = Integer.MIN_VALUE;

    for (int i = 1; i <= prices.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
      // 前端收费, 防止遇到min_value-fee这种溢出的情况
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);
    }

    return dp[prices.length][0];
  }

  /**
   * 滚动数组
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int maxProfit2(int[] prices, int fee) {
    // 开市前一天, 哨兵
    int dp_i_0 = 0;
    int dp_i_1 = Integer.MIN_VALUE;

    for (int price : prices) {
      int tmp = Math.max(dp_i_0, dp_i_1 + price);
      // 前端收费, 防止遇到min_value-fee这种溢出的情况
      dp_i_1 = Math.max(dp_i_1, dp_i_0 - price - fee);
      dp_i_0 = tmp;
    }

    return dp_i_0;
  }
}
