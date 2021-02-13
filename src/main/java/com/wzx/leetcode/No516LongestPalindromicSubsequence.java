package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">https://leetcode.com/problems/longest-palindromic-subsequence/</a>
 * @author wzx
 */
public class No516LongestPalindromicSubsequence {

  /**
   * 动态规划
   * dp[i][j]: s[i~j]的最长回文子序列
   * 递推公式: dp[i][j]= if s[i]==s[j]: dp[i+1][j-1]+2
   * |                  else        : max(dp[i+1][j], dp[i][j-1])
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public int longestPalindromeSubseq(String s) {
    int[][] dp = new int[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = 1;
    }

    for (int i = s.length() - 2; i >= 0; i--) {
      for (int j = i + 1; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[0][s.length() - 1];
  }
}
