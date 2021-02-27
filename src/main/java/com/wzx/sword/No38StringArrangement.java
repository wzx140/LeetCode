package com.wzx.sword;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/">https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/</a>
 */
public class No38StringArrangement {

  /**
   * 深搜
   * <p>
   * time: O(n!)
   * space: O(n)
   */
  public String[] permutation(String s) {
    char[] sArray = s.toCharArray();
    Arrays.sort(sArray);
    List<String> res = new LinkedList<>();
    boolean[] visit = new boolean[sArray.length];
    recursion(sArray, visit, new StringBuilder(), res);
    return res.toArray(new String[0]);
  }

  private void recursion(char[] s, boolean[] visit, StringBuilder sb, List<String> res) {
    if (sb.length() == s.length) {
      res.add(sb.toString());
      return;
    }

    for (int i = 0; i < s.length; i++) {
      if (visit[i]) continue;
      // 防止重复
      if (i > 0 && s[i] == s[i - 1] && !visit[i] && !visit[i - 1]) continue;
      // 回溯
      visit[i] = true;
      sb.append(s[i]);
      recursion(s, visit, sb, res);
      sb.deleteCharAt(sb.length() - 1);
      visit[i] = false;
    }
  }
}
