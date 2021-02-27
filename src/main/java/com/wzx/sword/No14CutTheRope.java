package com.wzx.sword;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/jian-sheng-zi-lcof/">https://leetcode-cn.com/problems/jian-sheng-zi-lcof/</a>
 */
public class No14CutTheRope {

  /**
   * 动态规划
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public int cuttingRope1(int n) {
    if (n <= 3) return n - 1;

    // 长度为n的绳子, 剪成m段的乘积最大值
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;

    for (int i = 4; i <= n; i++) {
      // 分别从2~i-1处减一刀, 比较处最大值
      for (int split = 2; split < i; split++) {
        dp[i] = Math.max(dp[i], dp[split] * dp[i - split]);
      }
    }

    return dp[n];
  }

  /**
   * 贪婪
   * 找到规律，尽可能多减长度为3的绳子，不允许长度为1的绳子，如果有则与长度为3的绳子拼成两个长度为2的绳子
   * <p>
   * time: O(1)
   * space: O(1)
   */
  public int cuttingRope2(int n) {
    if (n <= 3) return n - 1;

    int num3 = n / 3;
    n -= num3 * 3;

    int num2 = n / 2;
    n -= num2 * 2;

    if (n != 0) {
      num2 += 2;
      num3 -= 1;
    }

    return (int) (Math.pow(2, num2) * Math.pow(3, num3));
  }
}
