package com.wzx.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/edit-distance/">https://leetcode.com/problems/edit-distance/</a>
 */
public class No72EditDistance {


  /**
   * 深搜+备忘录
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public int minDistance1(String word1, String word2) {
    return recursion(word1, word2, word1.length() - 1, word2.length() - 1, new HashMap<>());
  }

  private int recursion(String word1, String word2, int i, int j, Map<List<Integer>, Integer> memo) {
    // 如果word1已经匹配到头了, 那么只能直接添加[0,j]的word2; word2同理
    if (i == -1) return j + 1;
    if (j == -1) return i + 1;

    List<Integer> curEntry = Arrays.asList(i, j);
    if (memo.containsKey(curEntry)) return memo.get(curEntry);

    if (word1.charAt(i) == word2.charAt(j)) {
      // 当前位置字符相同, 不需要操作
      int dist = recursion(word1, word2, i - 1, j - 1, memo);
      memo.put(curEntry, dist);
      return dist;
    } else {
      // s1中插入不同字符
      int insert = recursion(word1, word2, i, j - 1, memo) + 1;
      // s1中删除不同字符
      int delete = recursion(word1, word2, i - 1, j, memo) + 1;
      // s1中替换不同字符
      int replace = recursion(word1, word2, i - 1, j - 1, memo) + 1;

      int dist = Math.min(Math.min(insert, delete), replace);
      memo.put(curEntry, dist);
      return dist;
    }
  }

  /**
   * dp[i][j]: word1的[0,i-1]子串和word2的[0,j-1]子串匹配的最小操作数
   * dp[0][0]代表word1和word2都为空
   * 递推公式: if word1[i-1]==word2[j-1]: dp[i][j]=dp[i-1][j-1]
   * else: dp[i][j]=min(dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]+1)
   * <p>
   * time: O(n^2)
   * space: O(n^2)
   */
  public int minDistance2(String word1, String word2) {
    int n = word1.length(), m = word2.length();
    int[][] dp = new int[n + 1][m + 1];
    // 边界条件, 一个子串为空时
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = i;
    }
    for (int i = 0; i < m + 1; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int insertAndDelete = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
          int replace = dp[i - 1][j - 1] + 1;
          dp[i][j] = Math.min(replace, insertAndDelete);
        }
      }
    }

    return dp[n][m];
  }
}
