package com.wzx.sword;

/**
 * @see <a href="https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387">https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387</a>
 * @author wzx
 */
public class No10StepUp {

  /**
   * 找规律，然后动态规划
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public static int jumpFloor1(int target) {
    if (0 == target || 1 == target) return 1;

    int[] dp = new int[target + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= target; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j];
      }
    }

    return dp[target];
  }

  /**
   * 找到规律 f(n) = 2f(n-1)
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public static int jumpFloor2(int target) {
    if (0 == target || 1 == target) return 1;

    int[] dp = new int[target + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= target; i++) {
      dp[i] = 2 * dp[i - 1];
    }

    return dp[target];
  }

  /**
   * 进一步找到规律 f(n) = 2^(n-1)
   * <p>
   * time: O(1)
   * space: O(1)
   */
  public static int jumpFloor3(int target) {
    if (0 == target || 1 == target) return 1;

    return (int) Math.pow(2, target - 1);
  }
}
