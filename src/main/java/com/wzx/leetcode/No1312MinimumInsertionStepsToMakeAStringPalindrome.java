package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 *
 * @author wzx
 */
public class No1312MinimumInsertionStepsToMakeAStringPalindrome {

  /**
   * 动态规划
   * dp[i][j]: 子字符i~j可以变成回文字符串的最小插入数
   * 递推方程: 两端相等则等于前一个子串
   * if s[i]==s[j]:
   * dp[i][j] = dp[i+1][j-1]
   * else: 将s[i-1,j]或者s[i,j-1]变成回文串，然后再左边或者右边再插入一个字符s[i,j]就变成回文串了
   * dp[i][j] = min(dp[i+1][j], dp[i][j-1])+1
   * 遍历顺序: 由中间向两侧递推，表现在二维状态从下至上，从左至右遍历
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public int minInsertions1(String s) {
    int length = s.length();
    int[][] dp = new int[length][length];
    // 初始化
//    for (int i = 0; i < length; i++) {
//      dp[i][i] = 0;
//    }

    // 由下至上，由左至右
    for (int i = length - 1; i >= 0; i--) {
      for (int j = i + 1; j < length; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
        }
      }
    }

    return dp[0][length - 1];
  }

  /**
   * 动态规划，状态压缩
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public int minInsertions2(String s) {
    // todo

    return -1;
  }
}
