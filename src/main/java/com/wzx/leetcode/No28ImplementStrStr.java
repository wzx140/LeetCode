package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * @author wzx
 */
public class No28ImplementStrStr {

  /**
   * RK算法
   * <p>
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
   * BM算法
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int strStr2(String haystack, String needle) {
    if (needle.isEmpty()) return 0;

    // haystack当前匹配起始位置
    int matchBegin = 0;
    while (matchBegin <= haystack.length() - needle.length()) {
      // 当前后缀匹配中第一个不相同的字符在haystack中的索引
      int mismatchIndex = matchBegin + needle.length() - 1;
      while (mismatchIndex >= matchBegin
              && needle.charAt(mismatchIndex - matchBegin) == haystack.charAt(mismatchIndex))
        mismatchIndex--;

      if (mismatchIndex == matchBegin - 1) {
        return matchBegin;
      } else {
        // 移动最长的那个距离
        int i1 = badCharMove(needle, haystack, mismatchIndex, matchBegin);
        int i2 = goodSuffixMove(needle, haystack,
                matchBegin + mismatchIndex + 1,
                matchBegin + needle.length() - 1);
        matchBegin += Math.max(i1, i2);
      }
    }
    return -1;
  }

  /**
   * 坏字符规则后移位数
   * <p>
   * GTTATAGCTGGTAGCGGCGAA  =>   GTTATAGCTGGTAGCGGCGAA
   * |       ^                           ^
   * GTAGCGGCG                          GTAGCGGCG
   * <p>
   * 在匹配串中从后至前找到与坏字符匹配的位置才是下一次可能的匹配位置
   *
   * @param mismatchIndex 坏字符在haystack中的索引
   * @param matchBegin    当前匹配开始索引
   */
  private int badCharMove(String needle, String haystack, int mismatchIndex, int matchBegin) {
    char badChar = haystack.charAt(mismatchIndex);
    for (int i = mismatchIndex - matchBegin - 1; i >= 0; i--) {
      if (needle.charAt(i) == badChar) return mismatchIndex - matchBegin - i;
    }
    // 如果没有找到相等的，则移动整个匹配串长度
    return needle.length();
  }

  /**
   * 好后缀规则后移位数
   * <p>
   * GTTATAGCTGGTAGCGGCGAA  =>   GTTATAGCTGGTAGCGGCGAA
   * |            ^^^                         ^^^
   * |      GTAGCGGCG                      GTAGCGGCG
   * 在匹配串中从后至前找到与好后缀匹配的位置才是下一次可能的匹配位置
   * <p>
   * GTTATAGCTGGTAGCGAGCGGCG  =>  GTTATAGCTGGTAGCGAGCGGCG
   * |            ^^^                          ^^^
   * |      CGAGCGGCG                           CGAGCGGCG
   * 若在匹配串中找不到好后缀，则在开头找好后缀的后缀(其前缀相当于被跳过)
   *
   * @param begin haystack中好后缀的开始索引
   * @param end   haystack中好后缀的结束索引
   */
  private int goodSuffixMove(String needle, String haystack, int begin, int end) {
    // fixme: this is a bug
    // 没有好后缀
    if (begin > end) return -1;

    // 好后缀开始位置
    int suffixBegin = end + 1;
    for (int i = end; i >= begin && needle.charAt(i - begin) == haystack.charAt(i); i--) {
      suffixBegin--;
    }

    // 每次偏移并寻找与好后缀匹配的位置
    for (int curSuffixBegin = suffixBegin; curSuffixBegin < end + 1; curSuffixBegin++) {
      boolean match = true;
      for (int j = 0; j < end - curSuffixBegin + 1; j++) {
        if (needle.charAt(j) != haystack.charAt(j + curSuffixBegin)) {
          match = false;
          break;
        }
      }

      if (match) return curSuffixBegin - begin;
    }
    // 如果没有匹配到好后缀，则移动整个匹配串长度
    return needle.length();
  }

  /**
   * KMP next数组
   * <p>
   * time: O(n)
   * space: O(m)
   */
  public int strStr3(String haystack, String needle) {
    if (needle.isEmpty()) return 0;

    int[] next = getNext(needle);
    // j:匹配串的位置
    int j = 0;
    // i:主串的位置
    for (int i = 0; i < haystack.length(); i++) {
      if (j == needle.length()) {
        return i - needle.length();
      } else if (needle.charAt(j) == haystack.charAt(i)) {
        j++;
      } else if (j != 0) {
        // 后移匹配串
        j = next[j];
        i--;
      }
    }

    // 尾部匹配
    if (j == needle.length()) {
      return haystack.length() - needle.length();
    }

    return -1;
  }

  private int[] getNext(String needle) {
    int[] next = new int[needle.length()];

    // j:最长可匹配前缀子串的下一个位置
    int j = 0;
    // 第一位没有字符，第二位一个字符，所以前两位都是0
    // i:已匹配前缀的下一个位置
    for (int i = 2; i < needle.length(); i++) {
      if (needle.charAt(i - 1) == needle.charAt(j)) {
        next[i] = ++j;
      } else if (j != 0) {
        // 取稍短的前缀继续匹配
        j = next[j];
        i--;
      } else {
        next[i] = 0;
      }
    }

    return next;
  }

  /**
   * KMP 有限状态机
   */
  public int strStr4(String haystack, String needle) {
    // todo
    return 0;
  }

}
