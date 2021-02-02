package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/super-egg-drop/">https://leetcode.com/problems/super-egg-drop/</a>
 * @see <a href="https://mp.weixin.qq.com/s/7XPGKe7bMkwovH95cnhang">https://mp.weixin.qq.com/s/7XPGKe7bMkwovH95cnhang</a>
 * @author wzx
 */
public class No887SuperEggDrop {

  /**
   * 动态规划, TLE
   * dp[n][k]:
   * |    n: 剩余未测楼层(1~N)个数, 由鸡蛋数判定剩余1～n还是N-i～N
   * |    k: 剩余鸡蛋数(0~K-1)
   * 边界条件: dp[i][1] = i, 只剩一个鸡蛋只能一层一层慢慢试
   * 递推公式: dp[n][k] = min_i{max(dp[i-1][k-1], dp[N-i][k])+1}
   * <p>
   * time: O(n^2*k)
   * space: O(nk)
   */
  public int superEggDrop1(int K, int N) {
    int[][] dp = new int[N + 1][K];
    // n=0说明剩余0个楼层
    for (int i = 0; i <= N; i++) {
      dp[i][0] = i;
    }

    for (int n = 1; n <= N; n++) {
      int move = Integer.MAX_VALUE;
      for (int k = 1; k < K; k++) {
        // 分别从1~n层扔鸡蛋尝试
        for (int i = 1; i <= n; i++) {
          move = Math.min(move, Math.max(dp[i - 1][k - 1], dp[n - i][k]) + 1);
        }
        dp[n][k] = move;
      }
    }

    return dp[N][K - 1];
  }

  /**
   * 对于f(i)=max(dp[i-1][k-1], dp[n-i][k])+1, g(x)=dp[i-1][k-1], h(x)=dp[n-i][k]来说
   * 上一个方法中对于f_min(i)的求解是线性的, 迭代i=[1, n]取最小值
   * 由于g(x)单增, h(x)单减, 所以当g(x)=h(x)时, 即找到了f_min(i), 所以可以使用二分搜索进行优化
   * <p>
   * time: O(nlogn*k)
   * space: O(nk)
   */
  public int superEggDrop2(int K, int N) {
    int[][] dp = new int[N + 1][K];
    // n=0说明剩余0个楼层
    for (int i = 0; i <= N; i++) {
      dp[i][0] = i;
    }

    for (int n = 1; n <= N; n++) {
      for (int k = 1; k < K; k++) {
        // 使用二分搜索找最小值
        int move = Integer.MAX_VALUE;
        int start = 1, end = n;
        while (start <= end) {
          int middle = (end - start) / 2 + start;
          int gi = dp[middle - 1][k - 1];
          int hi = dp[n - middle][k];
          if (gi > hi) {
            end = middle - 1;
            move = Math.min(move, gi + 1);
          } else if (gi < hi) {
            start = middle + 1;
            move = Math.min(move, hi + 1);
          } else {
            move = gi + 1;
            break;
          }
        }
        dp[n][k] = move;
      }
    }

    return dp[N][K - 1];
  }
}
