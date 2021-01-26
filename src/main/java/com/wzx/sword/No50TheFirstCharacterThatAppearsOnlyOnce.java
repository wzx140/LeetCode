package com.wzx.sword;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/">https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/</a>
 */
public class No50TheFirstCharacterThatAppearsOnlyOnce {

  /**
   * 哈希表
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public char firstUniqChar(String s) {
    int[] map = new int[26];
    char[] array = s.toCharArray();
    for (char ch : array) {
      map[ch - 'a']++;
    }
    for (char ch : array) {
      if (map[ch - 'a'] == 1) {
        return ch;
      }
    }
    return ' ';
  }
}
