package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/permutation-in-string/">https://leetcode.com/problems/permutation-in-string/</a>
 */
public class No567PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    // 字符串s1：要包含的字符
    Map<Character, Integer> target = new HashMap<>();
    for (char ch : s1.toCharArray()) {
      target.merge(ch, 1, Integer::sum);
    }
    int n = s2.length();
    // 窗口中合法字符数
    int valid = 0;
    // 窗口中已经包含的字符
    Map<Character, Integer> window = new HashMap<>();
    char[] sArray = s2.toCharArray();
    int right = 0;
    for (int left = 0; left <= n - s1.length(); left++) {
      // 向右拓展窗口, 窗口大小固定为p的长度
      for (; right - left + 1 <= s1.length(); right++) {
        if (!target.containsKey(sArray[right])) continue;
        window.merge(sArray[right], 1, Integer::sum);
        if (window.get(sArray[right]).equals(target.get(sArray[right]))) valid++;
      }
      // 判断当前是否为合法窗口
      if (valid == target.size()) {
        return true;
      }
      // 向左收缩窗口
      if (!target.containsKey(sArray[left])) continue;
      if (window.get(sArray[left]).equals(target.get(sArray[left]))) valid--;
      window.compute(sArray[left], (ch, num) -> num - 1);
    }

    return false;
  }
}
