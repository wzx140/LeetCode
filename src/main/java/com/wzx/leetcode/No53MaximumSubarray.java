package com.wzx.leetcode;

import java.util.Arrays;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">https://leetcode.com/problems/maximum-subarray/</a>
 */
public class No53MaximumSubarray {

  /**
   * 动态规划
   * dp[i]: 以第i个元素结尾的最大子串
   * 递推公式: dp[i] = max(nums[i], nums[i]+dp[i-1])
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int maxSubArray1(int[] nums) {
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;

    for (int i = 1; i <= nums.length; i++) {
      dp[i] = Math.max(nums[i - 1], nums[i - 1] + dp[i - 1]);
    }

    return Arrays.stream(dp).skip(1).max().orElse(0);
  }

  /**
   * 贪心，当子序列和小于0时，这部分子序列可以舍去，也可以由上一种动态规划的状态压缩推导而来
   * <p>
   * cur: 当前可能最大的子序列和；res: 最大子序列和
   * 递推公式: cur>0, cur=cur+num(即使num小于0使整个子序列和变小，仍期待后面出现一个稍大的数可以抵消这次变小)
   * |       cur<0, cur=num(无论num是什么，cur+num永远小于num)
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int maxSubArray2(int[] nums) {
    int cur = 0;
    int res = Integer.MIN_VALUE;
    for (int num : nums) {
      if (cur < 0) {
        cur = num;
      } else {
        cur += num;
      }
      res = Math.max(cur, res);
    }

    return res;
  }

  /**
   * 分治
   * <p>
   * time: O(nlogn)
   * space: O(logn)
   */
  public int maxSubArray3(int[] nums) {

    return help(nums, 0, nums.length - 1);
  }

  private int help(int[] nums, int left, int right) {
    if (left == right) return nums[left];

    // 左右子串的最大子串和
    int middle = (right - left) / 2 + left;
    int leftMax = help(nums, left, middle);
    int rightMax = help(nums, middle + 1, right);

    // 跨越middle的最大子串和
    int leftBorderMax = nums[middle];
    int cur = nums[middle];
    for (int i = middle - 1; i >= left; i--) {
      cur += nums[i];
      leftBorderMax = Math.max(leftBorderMax, cur);
    }
    int rightBorderMax = nums[middle + 1];
    cur = nums[middle + 1];
    for (int i = middle + 2; i <= right; i++) {
      cur += nums[i];
      rightBorderMax = Math.max(rightBorderMax, cur);
    }

    return Math.max(Math.max(leftMax, rightMax), leftBorderMax + rightBorderMax);
  }
}
