package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 *
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
    int wordBegin = s.length() - 1;
    while (wordBegin >= 0 && s.charAt(wordBegin) == ' ') wordBegin--;

    // 从后往前遍历
    while (wordBegin >= 0) {
      int wordEnd = wordBegin;
      while (wordBegin >= 0 && s.charAt(wordBegin) != ' ') wordBegin--;
      if (s.charAt(wordBegin + 1) != ' ') sb.append(s, wordBegin + 1, wordEnd + 1).append(' ');
      // 跳过空格
      while (wordBegin >= 0 && s.charAt(wordBegin) == ' ') wordBegin--;
    }
    // 删除最后一个多余空格
    if (sb.length() > 0) sb.setLength(sb.length() - 1);

    return sb.toString();
  }
}
