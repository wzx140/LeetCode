package com.wzx.sword;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 *
 * @author wzx
 */
public class No31StackSequence {

  /**
   * time: O(n)
   * space: O(n)
   */
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    if (pushed.length != popped.length) return false;

    Deque<Integer> stack = new ArrayDeque<>(pushed.length);
    int pushIndex = 0;
    int popIndex = 0;
    while (pushIndex < pushed.length) {
      if (pushed[pushIndex] != popped[popIndex]) {
        // 如果不相等，说明当前操作为压栈
        stack.push(pushed[pushIndex++]);
      } else {
        // 如果相等，说明当前操作为先压栈紧接着开始弹栈
        pushIndex++;
        popIndex++;
        while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
          stack.pop();
          popIndex++;
        }
      }
    }

    return stack.isEmpty();
  }
}
