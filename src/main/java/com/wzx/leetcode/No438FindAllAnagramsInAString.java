package com.wzx.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * @author wzx
 */
public class No438FindAllAnagramsInAString {

  /**
   * 滑动窗口
   *
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> findAnagrams(String s, String p) {
    Map<Character, Integer> target = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
      target.merge(p.charAt(i), 1, Integer::sum);
    }
    Map<Character, Integer> window = new HashMap<>();
    // [left, right)
    int left = 0, right = 0;

    List<Integer> res = new LinkedList<>();
    int valid = 0;
    while (right < s.length()) {
      char rightCh = s.charAt(right);
      right++;
      if (target.containsKey(rightCh)){
        window.merge(rightCh, 1, Integer::sum);
        if (window.get(rightCh).equals(target.get(rightCh))) valid++;
      }
      // 收缩窗口始终保证窗口大小与p.size()相同, 即使添加非target字符, 也要收缩窗口
      while (right - left >= p.length()) {
        if (valid == target.size()) res.add(left);
        char leftCh = s.charAt(left);
        left++;
        if (!target.containsKey(leftCh)) continue;
        if (window.get(leftCh).equals(target.get(leftCh))) valid--;
        window.compute(leftCh, (ch, cnt) -> cnt - 1);
      }
    }

    return res;
  }
}
