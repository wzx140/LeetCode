package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/remove-duplicate-letters/">https://leetcode.com/problems/remove-duplicate-letters/</a>
 */
public class No316RemoveDuplicateLetters {

  /**
   * 利用栈，每次入栈时，判断当前字母的字典序是否小于之前的，弹出之前的重复的字母
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public String removeDuplicateLetters1(String s) {
    // 当前元素之后的可用字母计数, 防止字母缺失
    int[] cnt = new int[26];
    // 当前元素之前的访问过的字母, 防止添加重复字母
    boolean[] visit = new boolean[26];
    // 目标字符串的倒序, 目的为快速访问和替换目标字符串的最后一位
    Deque<Character> stack = new LinkedList<>();
    char[] charArray = s.toCharArray();
    // 计数
    for (char ch : charArray) {
      cnt[ch - 'a']++;
    }

    for (char ch : charArray) {
      // 每访问一个字母, 则在计数中减一
      cnt[ch - 'a']--;
      // 不可能添加重复字母, 因为重复的字母字典序相同, 不需要替换
      if (visit[ch - 'a']) continue;
      // 去除前面可替换的字典序较大的字母
      while (!stack.isEmpty() &&
              stack.peekFirst() > ch &&
              cnt[stack.peekFirst() - 'a'] > 0) {
        visit[stack.peekFirst() - 'a'] = false;
        stack.removeFirst();
      }
      stack.addFirst(ch);
      visit[ch - 'a'] = true;
    }

    StringBuilder sb = new StringBuilder(stack.size());
    while (!stack.isEmpty()) {
      sb.append(stack.pollFirst());
    }
    // 栈要逆序
    return sb.reverse().toString();
  }
}
