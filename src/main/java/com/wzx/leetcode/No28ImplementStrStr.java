package com.wzx.leetcode;

import java.util.Arrays;

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
   * time: O(m+n)
   * space: O(n)
   */
  public int strStr2(String haystack, String needle) {
    if (needle.isEmpty()) return 0;
    // bmBc: 坏字符对应的匹配串后移距离
    int[] bmBc = getBmBc(needle);
    // bmGs: 好后缀位置对应的匹配串后移距离
    int[] bmGs = getBmGs(needle);
    int n = haystack.length();
    int m = needle.length();

    // 主串的当前匹配起始位置
    int matchBegin = 0;
    while (matchBegin <= n - m) {
      // 坏字符在匹配串中的索引
      int mismatchIndex = m - 1;
      while (mismatchIndex >= 0
              && needle.charAt(mismatchIndex) == haystack.charAt(mismatchIndex + matchBegin))
        mismatchIndex--;

      if (mismatchIndex == -1) {
        // 没有找到坏字符，说明完全匹配
        return matchBegin;
      } else {
        // 移动最长的那个距离
        matchBegin += Math.max(bmBc[needle.charAt(mismatchIndex) - 'a'], bmGs[mismatchIndex]);
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
   */
  private int[] getBmBc(String needle) {
    int[] bmBc = new int[26];
    int m = needle.length();
    Arrays.fill(bmBc, m);
    // 从左往右遍历，那么最终map会存放最靠右的索引位置
    for (int i = 0; i < m; i++) {
      // i处字符移动到匹配串尾部的距离
      bmBc[needle.charAt(i) - 'a'] = m - 1 - i;
    }
    return bmBc;
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
   */
  private int[] getBmGs(String needle) {
    int m = needle.length();
    // 先建立suffix数组
    int[] suffix = new int[m];
    suffix[m - 1] = m;
    for (int i = m - 2; i >= 0; i--) {
      int j = i;
      while (j >= 0 && needle.charAt(j) == needle.charAt(m - 1 - i + j)) j--;
      suffix[i] = i - j;
    }

    int[] bmGs = new int[m];
    // 以下三种情况，越靠后说明优先级越高
    // 没有任何匹配的子串或者前缀
    Arrays.fill(bmGs, m);
    // 找到一个好后缀的前缀匹配的模式串前缀
    for (int i = m - 1; i >= 0; i--) {
      if (suffix[i] == i + 1) {
        for (int j = 0; j < m - 1 - i; j++) {
          bmGs[j] = m - 1 - i;
        }
      }
    }
    // 模式串中有子串匹配上好后缀
    for (int i = 0; i <= m - 2; i++) {
      bmGs[m - 1 - suffix[i]] = m - 1 - i;
    }

    return bmGs;
  }

  /**
   * KMP
   * <p>
   * time: O(m+n)
   * space: O(n)
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

}
