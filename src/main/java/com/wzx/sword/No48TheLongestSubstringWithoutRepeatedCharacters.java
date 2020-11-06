package com.wzx.sword;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 *
 * @author wzx
 */
public class No48TheLongestSubstringWithoutRepeatedCharacters {

  /**
   * 动态规划
   * dp[i]: 以s[i]结尾的最长不重复子串长度
   * 递推公式: s[j]为s[i]左边最近的相同字符
   * |   如果 dp[i-1]<i-j, 说明s[j]在原不重复子串的左边，dp[i]=dp[i-1]+1
   * |   如果 dp[i-1]>=i-j,说明s[j]在原不重复子串内，dp[i]=i-j
   * 由此看出dp[i]可以只由dp[i-1]推导出来，进一步优化
   * <p>
   * time: O(n)
   * space: O(128)
   */
  public int lengthOfLongestSubstring1(String s) {
    int[] dict = new int[128];
    Arrays.fill(dict, -1);
    int dp = 0;
    // dp中的最大值
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      // 哈希表用于查找字符
      int j = dict[s.charAt(i)];
      dict[s.charAt(i)] = i;

      if (dp < i - j) {
        dp = dp + 1;
      } else {
        dp = i - j;
      }
      // 更新全局最大值
      res = Math.max(res, dp);
    }

    return res;
  }

  /**
   * 滑动窗口
   * <p>
   * time: O(n)
   * space: O(128)
   */
  public int lengthOfLongestSubstring2(String s) {
    int[] dict = new int[128];
    Arrays.fill(dict, -1);
    int res = 0;
    int left = 0;

    // 窗口([left,right])表示以right结尾的最长不重复子串
    for (int right = 0; right < s.length(); right++) {
      // 更新左指针
      left = Math.max(dict[s.charAt(right)] + 1, left);

      // 更新哈希表
      dict[s.charAt(right)] = right;

      // 更新全局最大值
      res = Math.max(res, right - left + 1);
    }

    return res;
  }
}
