package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * @author wzx
 */
public class No1143LongestCommonSubsequence {

  /**
   * dp[i][j]: nums1[0~i]和nums2[0~j]的最长公共子序列长度
   * 递推公式:  if nums1[i]==nums[j]: dp[i][j] = dp[i-1][j-1]+1
   * |        else                : dp[i][j] = max(dp[i-1][j], dp[i][j-1])
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    for (int i = 0; i <= text1.length(); i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i <= text2.length(); i++) {
      dp[0][i] = 0;
    }

    for (int i = 1; i <= text1.length(); i++) {
      for (int j = 1; j <= text2.length(); j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[text1.length()][text2.length()];
  }
}
