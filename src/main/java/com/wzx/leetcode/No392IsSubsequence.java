package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/is-subsequence/
 *
 * @author wzx
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
    Map<Character, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      if (!map.containsKey(ch)) map.put(ch, new ArrayList<>());
      map.get(ch).add(i);
    }
    // 遍历s, 搜索t的倒排索引
    int tPointer = 0;
    for (char ch : s.toCharArray()) {
      // t中不含s的字符
      if (!map.containsKey(ch)) return false;
      List<Integer> tIndexList = map.get(ch);
      int index = lower(tIndexList, tPointer);
      // t中index之后不含s的字符
      if (index >= tIndexList.size()) return false;
      tPointer = tIndexList.get(index) + 1;
    }

    return true;
  }

  /**
   * 当target不存在时, 下边界二分搜索返回恰好比target大的元素
   */
  private int lower(List<Integer> nums, int target) {
    int start = 0, end = nums.size() - 1;
    while (start <= end) {
      int middle = (end - start) / 2 + start;
      if (target > nums.get(middle)) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }

    return start;
  }
}
