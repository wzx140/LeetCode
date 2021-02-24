package com.wzx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">https://leetcode.com/problems/generate-parentheses/</a>
 */
public class No22GenerateParentheses {

  /**
   * 回溯
   * <p>
   * time: 卡特兰数
   * space: 卡特兰数
   */
  public List<String> generateParenthesis(int n) {
    List<String> res = new LinkedList<>();
    recursion(n * 2, 0, new StringBuilder(), res);
    return res;
  }

  private void recursion(int n, int left, StringBuilder track, List<String> res) {
    // 右括号较多
    if (left < 0) return;
    // 左括号较多
    if (left > n) return;
    if (n == 0) {
      res.add(track.toString());
      return;
    }

    track.append('(');
    recursion(n - 1, left + 1, track, res);
    track.deleteCharAt(track.length() - 1);

    track.append(')');
    recursion(n - 1, left - 1, track, res);
    track.deleteCharAt(track.length() - 1);
  }
}
