package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author wzx
 */
public class No5LongestPalindromicSubstring {

  /**
   * 动态规划
   * dp[i][j]: s[i~j]是否是回文串
   * 递推公式: if s[i]==s[j]: dp[i][j] = dp[i + 1][j - 1](注意回文串长度为偶数的特殊情况)
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public String longestPalindrome1(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = true;
    }

    int begin = 0;
    int maxLength = 1;
    for (int i = s.length() - 2; i >= 0; i--) {
      for (int j = i + 1; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          // 长度为2的回文子串
          if (j - i == 1) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        // 标记最大回文子串
        if (dp[i][j] && j - i + 1 > maxLength) {
          begin = i;
          maxLength = j - i + 1;
        }
      }
    }

    return s.substring(begin, begin + maxLength);
  }

  /**
   * 左右指针
   * <p>
   * time: O(n^2)
   * space: O(1)
   */
  public String longestPalindrome2(String s) {
    int maxLen = 0;
    int begin = 0;
    for (int i = 0; i < s.length(); i++) {
      int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
      if (len > maxLen) {
        maxLen = len;
        begin = i - (len - 1) / 2;
      }
    }

    return s.substring(begin, begin + maxLen);
  }

  private int expand(String s, int left, int right) {
    // 左右指针
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      right++;
      left--;
    }

    return (right - 1) - (left + 1) + 1;
  }
}
