package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * @author wzx
 */
public class No76MinimumWindowSubstring {

  /**
   * 滑动窗口
   *
   * time: O(n)
   * space: O(n)
   */
  public String minWindow(String s, String t) {
    // 要包含的字符
    Map<Character, Integer> target = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      target.merge(t.charAt(i), 1, Integer::sum);
    }
    // 窗口
    Map<Character, Integer> window = new HashMap<>();
    // [left, right)
    int left = 0, right = 0;
    // 符合要求的字母数, 防止每次判断window是否合法时, 只需比较valid和target.size()
    int valid = 0;
    // 最小窗口的起始索引和长度
    int begin = 0, len = Integer.MAX_VALUE;

    while (right < s.length()) {
      char rightCh = s.charAt(right);
      // 从右边扩大窗口
      right++;
      // 非target字符不会影响结果
      if (!target.containsKey(rightCh)) continue;
      // 更新window
      window.merge(rightCh, 1, Integer::sum);
      // 更新valid
      if (window.get(rightCh).equals(target.get(rightCh))) valid++;
      // window已经包含target中所有字符
      while (valid == target.size()) {
        // 找到当前最小合法window, 更新begin, len
        if (right - left < len) {
          begin = left;
          len = right - left;
        }
        char leftCh = s.charAt(left);
        // 从左边缩小窗口
        left++;
        // 非target字符不会影响结果
        if (!target.containsKey(leftCh)) continue;
        // 更新valid
        if (window.get(leftCh).equals(target.get(leftCh))) valid--;
        // 更新window
        window.compute(leftCh, (ch, cnt) -> cnt - 1);
      }
    }

    return len == Integer.MAX_VALUE ? "" : s.substring(begin, begin + len);
  }
}
