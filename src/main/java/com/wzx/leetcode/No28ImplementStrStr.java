package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * @author wzx
 */
public class No28ImplementStrStr {

  /**
   * BK算法
   *
   * time: O(n) 需要设计好的哈希算法以减少哈希冲突
   * space: O(1)
   */
  public int strStr1(String haystack, String needle) {
    if (needle.isEmpty()) return 0;

    int needleHash = initHashCode(needle, 0, needle.length() - 1);
    int haystackHash = initHashCode(haystack, 0, needle.length() - 1);
    int needleLength = needle.length();

    for (int i = 0; i <= haystack.length() - needleLength; i++) {
      // 为防止哈希冲突，哈希值相等需要重新比较
      if (needleHash == haystackHash && stringEquals(haystack, i, i + needleLength - 1, needle)) {
        return i;
      } else if (i < haystack.length() - needleLength) {
        // 增量更新哈希值
        haystackHash = haystackHash - haystack.charAt(i) + haystack.charAt(i + needleLength);
      }
    }

    return -1;
  }

  private int initHashCode(String str, int begin, int end) {
    // 字符asc码和作为哈希值
    return str.chars()
            .skip(begin)
            .limit(end - begin + 1)
            .sum();
  }

  private boolean stringEquals(String str, int begin, int end, String needle) {
    for (int i = begin; i < end; i++) {
      if (str.charAt(i) != needle.charAt(i - begin)) return false;
    }

    return true;
  }

  /**
   * RK算法
   */
  public int strStr2(String haystack, String needle) {
    // todo
    return 0;
  }

  /**
   * KMP next数组
   */
  public int strStr3(String haystack, String needle) {
    // todo
    return 0;
  }

  /**
   * KMP 有限状态机
   */
  public int strStr4(String haystack, String needle) {
    // todo
    return 0;
  }

}
