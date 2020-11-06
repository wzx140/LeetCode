package com.wzx.sword;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * @author wzx
 */
public class No50TheFirstCharacterThatAppearsOnlyOnce {

  /**
   * 哈希表
   *
   * time: O(n)
   * space: O(n)
   */
  public char firstUniqChar(String s) {
    Map<Character, Boolean> map = new LinkedHashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        map.put(ch, true);
      } else {
        map.put(ch, false);
      }
    }

    for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
      if (!entry.getValue()) return entry.getKey();
    }

    return ' ';
  }
}
