package com.wzx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 * the same as 1081
 *
 * @author wzx
 */
public class No316RemoveDuplicateLetters {

  /**
   * 利用栈，每次入栈时，判断当前字母的字典序是否小于之前的，弹出之前的重复的字母
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public String removeDuplicateLetters1(String s) {
    // 当前元素之后的可用字母计数
    Map<Character, Integer> map = new HashMap<>(s.length());
    // 当前元素之前的访问过的字母
    Set<Character> visit = new HashSet<>(s.length());
    // 目标字符串的倒序
    Deque<Character> stack = new ArrayDeque<>(s.length());

    // 计数
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int num = map.getOrDefault(ch, 0);
      map.put(ch, num + 1);
    }

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      // 每访问一个字母，则在计数中减一
      map.put(ch, map.get(ch) - 1);

      // 不添加重复字母
      if (!visit.contains(ch)) {
        // 去除前面可替换的字典序较大的字母
        while (!stack.isEmpty() &&
                stack.peek() > ch &&
                map.get(stack.peek()) != 0) {

          visit.remove(stack.peek());
          stack.pop();
        }
        stack.push(ch);
        visit.add(ch);
      }
    }

    // 栈要逆序
    StringBuilder sb = new StringBuilder(stack.size());
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.reverse().toString();
  }
}
