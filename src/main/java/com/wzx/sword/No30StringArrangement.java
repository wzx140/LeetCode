package com.wzx.sword;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7
 *
 * @author wzx
 */
public class No30StringArrangement {

  /**
   * 深搜
   * <p>
   * time: O(n^2)
   * space: O(1)
   */
  public ArrayList<String> Permutation(String str) {
    if (str.isEmpty()) return new ArrayList<>();

    // 红黑树，有序
    Set<String> res = new TreeSet<>();
    recursion(str.toCharArray(), 0, res);

    return new ArrayList<>(res);
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
