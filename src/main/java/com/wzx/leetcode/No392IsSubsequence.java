package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/is-subsequence/">https://leetcode.com/problems/is-subsequence/</a>
 */
public class No392IsSubsequence {

  /**
   * 双指针
   * <p>
   * time: O(max(m,n))
   * space: O(1)
   */
  public boolean isSubsequence1(String s, String t) {
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) i++;
      j++;
    }

    return i == s.length();
  }

  /**
   * 哈希表+二分搜索
   * <p>
   * time: O(mlogn) m远远小于n
   * space: O(n)
   */
  public boolean isSubsequence2(String s, String t) {
    // t的倒排索引
    Map<Character, List<Integer>> invertIndex = new HashMap<>();
    char[] sArray = s.toCharArray(), tArray = t.toCharArray();
    for (int i = 0; i < tArray.length; i++) {
      invertIndex.putIfAbsent(tArray[i], new ArrayList<>());
      invertIndex.get(tArray[i]).add(i);
    }

    // 保存当前t中搜索的位置
    int tPointer = 0;
    // 遍历s, 搜索t的倒排索引
    for (char ch : sArray) {
      // t中不含s字符
      if (!invertIndex.containsKey(ch)) return false;
      int index = lower(invertIndex.get(ch), tPointer);
      // t中找不到符合要求的s字符
      if (index == -1) return false;
      tPointer = index + 1;
    }

    return true;
  }

  /**
   * 二分下界搜索
   */
  private int lower(List<Integer> data, int target) {
    int start = 0, end = data.size() - 1;

    while (start <= end) {
      int middle = (end - start) / 2 + start;
      if (data.get(middle) > target) {
        end = middle - 1;
      } else if (data.get(middle) < target) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }

    if (start < data.size()) {
      return data.get(start);
    } else {
      return -1;
    }
  }
}
