package com.wzx.leetcode;

import java.util.Arrays;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/ones-and-zeroes/">https://leetcode.com/problems/ones-and-zeroes/</a>
 */
public class No474OnesAndZeroes {

  /**
   * 多重背包
   * <p>
   * time: O(mnS)
   * space: O(mn)
   */
  public int findMaxForm(String[] strs, int m, int n) {
    Pair[] bags = Arrays.stream(strs)
            .map(str -> {
              Pair pair = new Pair();
              for (char ch : str.toCharArray()) {
                if (ch == '1') {
                  pair.one++;
                } else {
                  pair.zero++;
                }
              }
              return pair;
            }).toArray(Pair[]::new);

    int[][] dp = new int[m + 1][n + 1];
    for (Pair bag : bags) {
      for (int i = m; i >= bag.zero; i--) {
        for (int j = n; j >= bag.one; j--) {
          dp[i][j] = Math.max(dp[i][j], dp[i - bag.zero][j - bag.one] + 1);
        }
      }
    }

    return dp[m][n];
  }

  private static class Pair {
    public int zero = 0;
    public int one = 0;
  }
}
