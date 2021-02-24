package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/regular-expression-matching/">https://leetcode.com/problems/regular-expression-matching/</a>
 */
public class No10RegularExpressionMatching {

  /**
   * 动态规划
   * dp[i][j]：两个字符串指针的位置，当前位置之前的子串是否匹配
   * 1. 当前位置是否匹配：p[j] == '.' || p[j] == s[i]，不匹配说明当前子串不匹配，返回false
   * 2. 下一个位置是否是*
   * 3. 如果是，判断 dp[i + 1][j](多次)或dp[i][j+2](零次)
   * 4. 如果不是，判断 dp[i + 1][j+1]
   */

  enum Result {
    TRUE,
    FALSE
  }

  /**
   * 递归+备忘录 自顶向下
   * <p>
   * time: O(mn)
   * space: O(mn)
   */
  public boolean isMatch1(String s, String p) {
    // 最后一位做哨兵
    Result[][] memo = new Result[s.length() + 1][p.length() + 1];
    return recursion(s, p, 0, 0, memo);
  }

  private boolean recursion(String s, String p, int i, int j, Result[][] memo) {
    if (memo[i][j] != null) return memo[i][j] == Result.TRUE;

    boolean res = false;
    // pattern匹配到结尾时，str也必须到结尾
    if (j == p.length()) {
      res = (i == s.length());
    } else {
      // 当前位置字符是否匹配
      boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

      if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
        // 当前字符被*修饰
        // 如果当前字符不匹配，则*只能解释为0个
        // 如果当前字符匹配，则*可以解释为0个，多个
        res = recursion(s, p, i, j + 2, memo)
                || (firstMatch && recursion(s, p, i + 1, j, memo));
      } else {
        // 当前字符没有被*修饰，在当前字符匹配的情况下继续下一个匹配
        res = firstMatch && recursion(s, p, i + 1, j + 1, memo);
      }
    }

    memo[i][j] = res ? Result.TRUE : Result.FALSE;
    return memo[i][j] == Result.TRUE;
  }

  /**
   * 动归
   * <p>
   * time: O(mn)
   * space: O(mn)
   */
  public boolean isMatch2(String s, String p) {
    int n = s.length(), m = p.length();
    // dp[i][j]: i~n的字符串和j～m的匹配串是否匹配
    boolean[][] dp = new boolean[n + 1][m + 1];
    // 边界条件
    // 空字符串和空匹配串可以匹配
    dp[n][m] = true;
    // 空匹配串和非空字符串不可以匹配
    // dp[0~n][m] = false
    // 空字符串只有和带*的匹配串匹配
    for (int i = m - 2; i >= 0; i--) {
      dp[n][i] = p.charAt(i + 1) == '*' && dp[n][i + 2];
    }

    // 从后往前倒退
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        boolean firstMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';

        if (j < m - 1 && p.charAt(j + 1) == '*') {
          dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
        } else {
          dp[i][j] = firstMatch && dp[i + 1][j + 1];
        }
      }
    }
    return dp[0][0];
  }
}
