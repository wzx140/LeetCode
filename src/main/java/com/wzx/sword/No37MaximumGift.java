package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @author wzx
 */
public class No37MaximumGift {

  /**
   * 回溯+备忘录
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int maxValue1(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;

    int m = grid.length;
    int n = grid[0].length;
    int[][] memo = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        memo[i][j] = -1;
      }
    }

    recursion(grid, m, n, 0, 0, 0, memo);

    return memo[m - 1][n - 1];
  }

  private void recursion(int[][] grid, int m, int n, int i, int j, int gift, int[][] memo) {
    int curGift = grid[i][j] + gift;
    if (curGift <= memo[i][j]) {
      return;
    } else {
      memo[i][j] = curGift;
    }

    if (i < m - 1) recursion(grid, m, n, i + 1, j, curGift, memo);
    if (j < n - 1) recursion(grid, m, n, i, j + 1, curGift, memo);
  }

  /**
   * 动态规划
   * dp[i][j]: 从左上角走到(i,j)的最大礼物值
   * 递推公式: dp[i][j] = grid[i][j] + max(dp[i - 1][j], dp[i][j - 1])
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int maxValue2(int[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) return 0;

    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];

    for (int i = 1; i < m; i++) {
      dp[i][0] = grid[i][0] + dp[i - 1][0];
    }
    for (int i = 1; i < n; i++) {
      dp[0][i] = grid[0][i] + dp[0][i - 1];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[m - 1][n - 1];
  }
}
