package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/stone-game/">https://leetcode.com/problems/stone-game/</a>
 */
public class No877StoneGame {

  /**
   * 动态规划
   * dp[i][j][k]: piles[i~j]中, k=0先手所能获得的最大分数, k=1后手所能获得的最大分数
   * 边界条件: i==j, dp[i][j][0] = piles[i], dp[i][j][1] = 0
   * dp[i][j][0] = max(piles[i]+dp[i+1][j][1], piles[j]+dp[i][j-1][1])  先手取得了piles[i]后, 下一步就变成了piles[i+1~j]的后手
   * dp[i][j][1] = 如果先手选择piles[i], dp[i+1][j][0]; 如果先手选择piles[j], dp[i][j-1][0]
   * 遍历方式: 画图可看出, 应该斜着遍历
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public boolean stoneGame(int[] piles) {
    int n = piles.length;

    int[][][] dp = new int[n][n][2];
    for (int i = 0; i < n; i++) {
      dp[i][i][0] = piles[i];
      dp[i][i][1] = 0;
    }

    // 斜着遍历
    for (int delta = 1; delta < n; delta++) {
      for (int i = 0; i < n - delta; i++) {
        int j = i + delta;

        int getI = piles[i] + dp[i + 1][j][1];
        int getJ = piles[j] + dp[i][j - 1][1];
        if (getI > getJ) {
          dp[i][j][0] = getI;
          dp[i][j][1] = dp[i + 1][j][0];
        } else {
          dp[i][j][0] = getJ;
          dp[i][j][1] = dp[i][j - 1][0];
        }
      }
    }

    return dp[0][n - 1][0] > dp[0][n - 1][1];
  }
}
