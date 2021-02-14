package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/</a>
 * @author wzx
 */
public class No309BestTimeToBuyAndSellStockWithCooldown {

  /**
   * 股票问题动态规划统一模板
   *
   * dp[i][k][state]: i当前天数, k当前最多进行的交易次数, state当前是否持有股票, 值为当前收益
   * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+price[i])
   * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-price[i])
   */

  /**
   * 在122. Best Time to Buy and Sell Stock II的基础上增加了冷却时间
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int maxProfit1(int[] prices) {
    int[][] dp = new int[prices.length + 2][2];
    // 边界条件, 开市前两天, 哨兵
    dp[0][0] = 0;
    dp[0][1] = Integer.MIN_VALUE;
    dp[1][0] = 0;
    dp[1][1] = Integer.MIN_VALUE;

    for (int i = 2; i <= prices.length + 1; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 2]);
      // 购买含有冷却时间
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 2]);
    }

    return dp[prices.length + 1][0];
  }

  /**
   * 滚动数组
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int maxProfit2(int[] prices) {
    // 开市前两天, 哨兵
    int dp_i1_0 = 0;
    int dp_i_1 = Integer.MIN_VALUE;
    int dp_i_0 = 0;

    for (int price : prices) {
      int tmp = Math.max(dp_i_0, dp_i_1 + price);
      // 购买含有冷却时间
      dp_i_1 = Math.max(dp_i_1, dp_i1_0 - price);

      dp_i1_0 = dp_i_0;
      dp_i_0 = tmp;
    }

    return dp_i_0;
  }
}
