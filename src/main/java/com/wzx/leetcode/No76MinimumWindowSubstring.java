package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/">https://leetcode.com/problems/minimum-window-substring/</a>
 */
public class No76MinimumWindowSubstring {

  /**
   * 滑动窗口
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public String minWindow(String s, String t) {
    // 字符串t：要包含的字符
    Map<Character, Integer> target = new HashMap<>();
    for (char ch : t.toCharArray()) {
      target.merge(ch, 1, Integer::sum);
    }
    int n = s.length();
    // 保存最小窗口
    int begin = 0, len = Integer.MAX_VALUE;
    // 窗口中合法字符数
    int valid = 0;
    // 窗口中已经包含的字符
    Map<Character, Integer> window = new HashMap<>();
    int left = 0;
    char[] sArray = s.toCharArray();
    for (int right = 0; right < n; right++) {
      if (!target.containsKey(sArray[right])) continue;
      // 向右拓展window
      window.merge(sArray[right], 1, Integer::sum);
      if (window.get(sArray[right]).equals(target.get(sArray[right]))) valid++;

      for(; valid == target.size(); left++){
        // 更新最小窗口
        if (right - left + 1 < len) {
          begin = left;
          len = right - left + 1;
        }
        if (!target.containsKey(sArray[left])) continue;
        // 向左缩减window
        if (window.get(sArray[left]).equals(target.get(sArray[left]))) valid--;
        window.compute(sArray[left], (ch, num) -> num - 1);
      }
    }

    if (len == Integer.MAX_VALUE) {
      return "";
    } else {
      return s.substring(begin, begin + len);
    }
  }
}
