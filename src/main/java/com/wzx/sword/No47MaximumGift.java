package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/">https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/</a>
 * @author wzx
 */
public class No47MaximumGift {

  /**
   * 深搜+备忘录
   * <p>
   * time: O(mn)
   * space: O(mn)
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
   * time: O(mn)
   * space: O(mn)
   */
  public int maxValue2(int[][] grid) {
    if (grid.length == 0) return 0;

    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m + 1][n + 1];
    // 递推
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = grid[i - 1][j - 1] + Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[m][n];
  }
}
