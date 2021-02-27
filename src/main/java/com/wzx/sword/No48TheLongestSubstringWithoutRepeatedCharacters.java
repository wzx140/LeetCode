package com.wzx.sword;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/">https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/</a>
 * @author wzx
 */
public class No48TheLongestSubstringWithoutRepeatedCharacters {

  /**
   * 动态规划
   * dp[i]: 以s[i]结尾的最长不重复子串长度
   * 递推公式:  如果以s[i-1]结尾的最长不重复子串中不存在s[i]的重复字符，则dp[i]=dp[i-1]+1
   * |        如果以s[i-1]结尾的最长不重复子串中存在s[i]的重复字符，  则dp[i]=i-dupIndex
   * 由此看出dp[i]可以只由dp[i-1]推导出来，进一步优化
   * <p>
   * time: O(n)
   * space: O(128)
   */
  public int lengthOfLongestSubstring1(String s) {
    // 哈希表用于查找字符
    int[] dict = new int[128];
    Arrays.fill(dict, -1);
    int[] chars = s.chars().toArray();

    int dp = 0;
    int res = 0;
    for (int i = 0; i < chars.length; i++) {
      int ch = chars[i];

      // 与ch相同的最左边的索引
      int dupIndex = dict[s.charAt(i)];
      // nonDupIndex ~ i-1 为以i-1为末尾的最长不含重复字符的子串
      int nonDupIndex = i - dp;
      if (dupIndex < nonDupIndex) {
        // ch重复的字母不在 最长不含重复字符的子串 之内
        dp = dp + 1;
      } else {
        // 在之内
        dp = i - dupIndex;
      }

      dict[ch] = i;
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
    int[] chars = s.chars().toArray();

    int res = 0;
    // 窗口[left,right]表示以right结尾的最长不重复子串
    int left = 0;
    for(int right = 0; right < chars.length; right++){
      int ch = chars[right];
      int dupIndex = dict[ch];
      // 窗口更新
      left = Math.max(left, dupIndex + 1);

      dict[ch] = right;
      res = Math.max(right - left + 1, res);
    }
    return res;
  }
}
