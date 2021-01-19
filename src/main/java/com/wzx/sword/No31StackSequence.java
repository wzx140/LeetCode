package com.wzx.sword;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/">https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/</a>
 * @author wzx
 */
public class No31StackSequence {

  /**
   * 使用栈判断
   * time: O(n)
   * space: O(n)
   */
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Deque<Integer> stack = new ArrayDeque<>(pushed.length);
    int pushIndex = 0;
    int popIndex = 0;
    while (pushIndex < pushed.length) {
      if (pushed[pushIndex] != popped[popIndex]) {
        // 如果不相等，说明当前操作肯定为压栈
        stack.push(pushed[pushIndex++]);
      } else {
        // 如果相等，说明当前操作为先压栈紧接着开始弹栈
        pushIndex++;
        popIndex++;
        // 下一步操作可能为压栈也可能为弹栈
        while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
          stack.removeFirst();
          popIndex++;
        }
      }
    }

    return stack.isEmpty();
  }
}
