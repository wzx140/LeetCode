package com.wzx.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * @author wzx
 */
public class No36TranslateNumbersIntoStrings {

  private int[] num2digits(int num) {
    String numString = Integer.toString(num);
    int[] digits = new int[numString.length()];
    for (int i = 0; i < digits.length; i++) {
      digits[i] = numString.charAt(i) - '0';
    }

    return digits;
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

  private int recursion1(int[] digits, int offset) {
    if (offset >= digits.length - 1) return 1;

    int alpha = digits[offset] * 10 + digits[offset + 1];
    if (alpha >= 10 && alpha <= 25) {
      return recursion1(digits, offset + 2) + recursion1(digits, offset + 1);
    } else {
      return recursion1(digits, offset + 1);
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

  private int recursion2(int[] digits, int offset, Map<Integer, Integer> memo) {
    if (memo.containsKey(offset)) return memo.get(offset);

    int alpha = digits[offset] * 10 + digits[offset + 1];
    if (alpha >= 10 && alpha <= 25) {
      memo.put(offset, recursion2(digits, offset + 2, memo) + recursion2(digits, offset + 1, memo));
    } else {
      memo.put(offset, recursion2(digits, offset + 1, memo));
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
    int[] digits = num2digits(num);
    // i个元素之前的组合个数
    int[] dp = new int[digits.length + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= digits.length; i++) {
      int alpha = digits[i - 2] * 10 + digits[i - 1];
      if (alpha >= 10 && alpha <= 25) {
        dp[i] = dp[i - 1] + dp[i - 2];
      } else {
        dp[i] = dp[i - 1];
      }
    }

    return dp[dp.length - 1];
  }

  /**
   * 动态规划
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int translateNum4(int num) {
    int[] digits = num2digits(num);
    // 相对于方法3，只需保存前两个即可
    int pre = 1;
    int bepre = 1;
    for (int i = 1; i < digits.length; i++) {
      int alpha = digits[i - 1] * 10 + digits[i];
      int cur = 0;
      if (alpha >= 10 && alpha <= 25) {
        cur = pre + bepre;
      } else {
        cur = pre;
      }
      bepre = pre;
      pre = cur;
    }

    return pre;
  }
}
