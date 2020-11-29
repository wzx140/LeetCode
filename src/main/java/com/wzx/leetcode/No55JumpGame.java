package com.wzx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game/
 *
 * @author wzx
 */
public class No55JumpGame {

  /**
   * 动态规划
   * dp[i]: 从第i格是否可以到结尾
   * 递推: dp[i] = if true in dp[i+1]~dp[i+k] k当前可跳跃长度
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public boolean canJump1(int[] nums) {
    boolean[] dp = new boolean[nums.length];
    dp[nums.length - 1] = true;

    for (int i = nums.length - 2; i >= 0; i--) {
      int maxStep = Math.min(nums[i], nums.length - 1 - i);
      while (maxStep > 0 && !dp[i]) {
        dp[i] = dp[i + maxStep];
        maxStep--;
      }
    }

    return dp[0];
  }

  /**
   * 深搜+备忘录
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public boolean canJump2(int[] nums) {
    Index[] memo = new Index[nums.length];
    Arrays.fill(memo, Index.UNKNOWN);
    memo[nums.length - 1] = Index.GOOD;
    return dfs(nums, 0, memo);
  }

  private enum Index {
    GOOD, BAD, UNKNOWN
  }

  private boolean dfs(int[] nums, int pos, Index[] memo) {
    if (memo[pos] != Index.UNKNOWN) return memo[pos] == Index.GOOD;

    int step = Math.min(nums[pos], nums.length - 1 - pos);
    while (step > 0) {
      if (dfs(nums, pos + step, memo)) {
        memo[pos] = Index.GOOD;
        return true;
      }
      step--;
    }

    memo[pos] = Index.BAD;
    return false;
  }

  /**
   * 贪心, 自顶向下迭代计算出可以跳跃的最远距离
   *
   * time: O(n)
   * space: O(1)
   */
  public boolean canJump3(int[] nums) {
    int farthest = 0;
    for (int i = 0; i < nums.length; i++) {
      // 不能跳到当前位置
      if (farthest < i) {
        return false;
      }
      farthest = Math.max(farthest, i + nums[i]);
    }

    return farthest >= nums.length - 1;
  }
}
