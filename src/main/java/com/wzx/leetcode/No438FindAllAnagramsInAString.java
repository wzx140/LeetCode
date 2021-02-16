package com.wzx.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">https://leetcode.com/problems/find-all-anagrams-in-a-string/</a>
 */
public class No438FindAllAnagramsInAString {

  /**
   * 滑动窗口
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> findAnagrams(String s, String p) {
    // 字符串p：要包含的字符
    Map<Character, Integer> target = new HashMap<>();
    for (char ch : p.toCharArray()) {
      target.merge(ch, 1, Integer::sum);
    }
    int n = s.length();
    List<Integer> res = new LinkedList<>();
    // 窗口中合法字符数
    int valid = 0;
    // 窗口中已经包含的字符
    Map<Character, Integer> window = new HashMap<>();
    char[] sArray = s.toCharArray();
    int right = 0;
    for (int left = 0; left <= n - p.length(); left++) {
      // 向右拓展窗口, 窗口大小固定为p的长度
      for (; right - left + 1 <= p.length(); right++) {
        if (!target.containsKey(sArray[right])) continue;
        window.merge(sArray[right], 1, Integer::sum);
        if (window.get(sArray[right]).equals(target.get(sArray[right]))) valid++;
      }
      // 判断当前left位置, 是否为合法窗口
      if (valid == target.size()) {
        res.add(left);
      }
      // 向左收缩窗口
      if (!target.containsKey(sArray[left])) continue;
      if (window.get(sArray[left]).equals(target.get(sArray[left]))) valid--;
      window.compute(sArray[left], (ch, num) -> num - 1);
    }

    return res;
  }
}
