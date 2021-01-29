package com.wzx.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/">https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/</a>
 */
public class No46TranslateNumbersIntoStrings {

  private int[] num2digits(int num) {
    return Integer.toString(num)
            .chars()
            .map(x -> x - '0')
            .toArray();
  }

  /**
   * 深搜
   * <p>
   * time: O(2^n)
   * space: O(n)
   */
  public int translateNum1(int num) {
    return recursion1(num2digits(num), 0);
  }

  private int recursion1(int[] nums, int offset) {
    if (offset >= nums.length - 1) return 1;

    int alpha = nums[offset] * 10 + nums[offset + 1];
    if (alpha >= 10 && alpha <= 25) {
      return recursion1(nums, offset + 2) + recursion1(nums, offset + 1);
    } else {
      return recursion1(nums, offset + 1);
    }
  }

  /**
   * 带备忘录的深搜
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int translateNum2(int num) {
    int[] digits = num2digits(num);
    HashMap<Integer, Integer> memo = new HashMap<>(digits.length);
    memo.put(digits.length, 1);
    memo.put(digits.length - 1, 1);
    return recursion2(digits, 0, memo);
  }

  private int recursion2(int[] nums, int offset, Map<Integer, Integer> memo) {
    if (memo.containsKey(offset)) return memo.get(offset);

    int alpha = nums[offset] * 10 + nums[offset + 1];
    if (alpha >= 10 && alpha <= 25) {
      memo.put(offset, recursion2(nums, offset + 2, memo) + recursion2(nums, offset + 1, memo));
    } else {
      memo.put(offset, recursion2(nums, offset + 1, memo));
    }

    return memo.get(offset);
  }

  /**
   * 动态规划
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int translateNum3(int num) {
    int[] nums = num2digits(num);
    // i个元素之前的组合个数
    int[] dp = new int[nums.length + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < dp.length; i++) {
      // dp数组比nums多一个哨兵位
      int alpha = nums[i - 2] * 10 + nums[i - 1];
      if (alpha >= 10 && alpha <= 25) {
        dp[i] = dp[i - 1] + dp[i - 2];
      } else {
        dp[i] = dp[i - 1];
      }
    }

    return dp[dp.length - 1];
  }

  /**
   * 动态规划，状态压缩，贪心
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int translateNum4(int num) {
    int[] digits = num2digits(num);
    int dp_i_1 = 1;
    int dp_i_2 = 1;
    for (int i = 1; i < digits.length; i++) {
      int alpha = digits[i - 1] * 10 + digits[i];
      int dp_i;
      if (alpha >= 10 && alpha <= 25) {
        dp_i = dp_i_1 + dp_i_2;
      } else {
        dp_i = dp_i_1;
      }
      dp_i_2 = dp_i_1;
      dp_i_1 = dp_i;
    }

    return dp_i_1;
  }
}
