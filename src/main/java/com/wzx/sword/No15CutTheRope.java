package com.wzx.sword;

/**
 * https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8
 *
 * @author wzx
 */
public class No15CutTheRope {

  /**
   * 动归
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public static int cutRope1(int target) {
    if (target < 5) return target;

    int[] dp = new int[target + 1];
    for (int i = 0; i < 5; i++) {
      dp[i] = i;
    }

    for (int i = 4; i <= target; i++) {
      // 减一刀分解为子问题
      for (int j = 1; j < i; j++) {
        dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
      }
    }

    return dp[target];
  }

  /**
   * 贪婪
   * 找到规律，尽可能多减长度为3的绳子，不允许长度为1的绳子，如果有则与长度为3的绳子拼成两个长度为2的绳子
   * <p>
   * time: O(1)
   * space: O(1)
   */
  public static int cutRope2(int target) {
    if (target < 5) return target;

    int num3 = target / 3;
    target -= num3 * 3;

    int num2 = target / 2;
    target -= num2 * 2;

    if (target != 0) {
      num2 += 2;
      num3 -= 1;
    }

    return (int) (Math.pow(2, num2) * Math.pow(3, num3));
  }
}
