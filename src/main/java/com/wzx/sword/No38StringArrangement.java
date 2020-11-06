package com.wzx.sword;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @author wzx
 */
public class No38StringArrangement {

  /**
   * 深搜
   * <p>
   * time: O(n^2)
   * space: O(1)
   */
  public String[] permutation(String s) {
    if (s.isEmpty()) return new String[0];

    // 红黑树，有序
    Set<String> res = new TreeSet<>();
    recursion(s.toCharArray(), 0, res);

    return res.toArray(new String[0]);
  }

  /**
   * 回溯
   *
   * @param str 源字符串
   * @param pos 当前固定位置
   * @param res 排列组合
   */
  private void recursion(char[] str, int pos, Set<String> res) {
    // 最后一位固定，当前排列组合确定
    if (pos == str.length) {
      res.add(new String(str));
      return;
    }

    for (int i = pos; i < str.length; i++) {
      // [pos, length)中的字符都可以固定到当前位置
      swap(str, pos, i);
      recursion(str, pos + 1, res);
      swap(str, pos, i);
    }
  }

  private void swap(char[] str, int pos1, int pos2) {
    char tmp = str[pos1];
    str[pos1] = str[pos2];
    str[pos2] = tmp;
  }
}
