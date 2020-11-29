package com.wzx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * @author wzx
 */
public class No45JumpGameII {

  /**
   * 深搜+备忘录 elt
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public int jump1(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, nums.length);
    memo[nums.length - 1] = 0;

    return dfs(nums, 0, memo);
  }

  private int dfs(int[] nums, int pos, int[] memo) {
    if (memo[pos] < nums.length) return memo[pos];

    int minJump = nums.length;
    int maxPos = Math.min(nums[pos], nums.length - 1 - pos) + pos;
    for (int i = pos + 1; i <= maxPos; i++) {
      minJump = Math.min(minJump, dfs(nums, i, memo) + 1);
    }
    memo[pos] = minJump;

    return minJump;
  }

  /**
   * 动态规划 etl
   * dp[i]: 从i跳到结尾所需最小跳步
   * 递推公式: dp[i]: min(dp[i+1]~dp[dp[i+k]])
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public int jump2(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, nums.length);
    dp[nums.length - 1] = 0;

    for (int i = nums.length - 2; i >= 0; i--) {
      int maxStep = Math.min(nums[i], nums.length - 1 - i);
      for (int k = 1; k <= maxStep; k++) {
        dp[i] = Math.min(dp[i], dp[i + k] + 1);
      }
    }

    return dp[0];
  }

  /**
   * 贪心
   *
   * time: O(n)
   * space: O(1)
   */
  public int jump3(int[] nums) {
    int jump = 0;
    // 下一跳所能到达的最远距离
    int farthest = 0;
    // 上一跳所能到达的最远距离
    int lastStep = 0;

    for (int i = 0; i < nums.length; i++) {
      if (lastStep < i) {
        // 不能到达当前格点, 必须再次跳跃
        lastStep = farthest;
        jump++;
      }
      // 更新 上一跳所能到达的最远距离 范围内的最长跳跃距离, 即下一跳所能到达的最远距离
      farthest = Math.max(farthest, i + nums[i]);
    }

    return jump;
  }
}
