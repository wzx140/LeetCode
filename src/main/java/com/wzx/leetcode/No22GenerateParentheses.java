package com.wzx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * @author wzx
 */
public class No22GenerateParentheses {

  /**
   * 回溯
   *
   * time: 卡特兰数
   * space: 卡特兰数
   */
  public List<String> generateParenthesis(int n) {
    List<String> res = new LinkedList<>();
    recursion(0, n * 2, 0, new StringBuffer(), res);
    return res;
  }

  private void recursion(int start, int n, int left, StringBuffer track, List<String> res) {
    if (left < start - left) return;
    if (left > n / 2) return;
    if (start == n) {
      res.add(track.toString());
      return;
    }

    recursion(start + 1, n, left + 1, track.append('('), res);
    track.deleteCharAt(track.length() - 1);
    recursion(start + 1, n, left, track.append(')'), res);
    track.deleteCharAt(track.length() - 1);
  }
}
