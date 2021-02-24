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
    for (int right = 0; right < n; right++) {
      char rightCh = s.charAt(right);
      if (!target.containsKey(rightCh)) continue;
      // 向右拓展window
      window.merge(rightCh, 1, Integer::sum);
      if (window.get(rightCh).equals(target.get(rightCh))) valid++;

      while (left <= right && valid == target.size()) {
        char leftCh = s.charAt(left);
        // 更新最小窗口
        if (right - left + 1 < len) {
          begin = left;
          len = right - left + 1;
        }
        left++;
        if (!target.containsKey(leftCh)) continue;
        // 向左缩减window
        if (window.get(leftCh).equals(target.get(leftCh))) valid--;
        window.compute(leftCh, (ch, num) -> num - 1);
      }
    }

    if (len == Integer.MAX_VALUE) {
      return "";
    } else {
      return s.substring(begin, begin + len);
    }
  }
}
