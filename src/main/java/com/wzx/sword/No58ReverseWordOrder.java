package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/">https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/</a>
 * @author wzx
 */
public class No58ReverseWordOrder {

  /**
   * 滑动窗口
   *
   * time: O(n)
   * space: O(n)
   */
  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();

    // 去除末尾的空格
    int left = s.length() - 1;
    while (left >= 0 && s.charAt(left) == ' ') left--;

    // 从后往前遍历
    while (left >= 0) {
      int right = left;
      while (left >= 0 && s.charAt(left) != ' ') left--;
      if (s.charAt(left + 1) != ' ') sb.append(s, left + 1, right + 1).append(' ');
      // 跳过空格
      while (left >= 0 && s.charAt(left) == ' ') left--;
    }
    // 删除最后一个多余空格
    if (sb.length() > 0) sb.setLength(sb.length() - 1);

    return sb.toString();
  }
}
