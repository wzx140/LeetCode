package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/">https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/</a>
 * @author wzx
 */
public class No188BestTimeToBuyAndSellStock4 {

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
   * time: O(nk)
   * space: O(nk)
   */
  public int maxProfit1(int k, int[] prices) {
    if (k > prices.length / 2) {
      // 这时相当于无限制交易次数
      // 见122. best time to buy and sell stock II
      int dp_i_1 = Integer.MIN_VALUE;
      int dp_i_0 = 0;

      for (int price : prices) {
        int tmp = Math.max(dp_i_0, dp_i_1 + price);
        dp_i_1 = Math.max(dp_i_1, dp_i_0 - price);
        dp_i_0 = tmp;
      }

      return dp_i_0;
    }

    int[][][] dp = new int[prices.length + 1][k + 1][2];
    // 边界条件, 开市前一天, 哨兵
    dp[0][k][0] = 0;
    for (int i = 0; i <= k; i++) {
      dp[0][i][1] = Integer.MIN_VALUE;
    }

    for (int i = 1; i <= prices.length; i++) {
      // k=0已经不允许交易, 所以没有迭代的必要
      for (int j = 1; j <= k; j++) {
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
      }
    }

    return dp[prices.length][k][0];
  }

  /**
   * 滚动数组
   * <p>
   * time: O(nk)
   * space: O(k)
   */
  public int maxProfit2(int k, int[] prices) {
    if (k > prices.length / 2) {
      // 这时相当于无限制交易次数
      // 见122. best time to buy and sell stock II
      int dp_i_1 = Integer.MIN_VALUE;
      int dp_i_0 = 0;

      for (int price : prices) {
        int tmp = Math.max(dp_i_0, dp_i_1 + price);
        dp_i_1 = Math.max(dp_i_1, dp_i_0 - price);
        dp_i_0 = tmp;
      }

      return dp_i_0;
    }

    int[][] dp = new int[k + 1][2];
    // 边界条件, 开市前一天, 哨兵
    dp[k][0] = 0;
    for (int i = 0; i <= k; i++) {
      dp[i][1] = Integer.MIN_VALUE;
    }

    for (int price : prices) {
      // k=0已经不允许交易, 所以没有迭代的必要
      for (int j = 1; j <= k; j++) {
        int tmp = Math.max(dp[j][0], dp[j][1] + price);
        dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - price);
        dp[j][0] = tmp;
      }
    }

    return dp[k][0];
  }
}
