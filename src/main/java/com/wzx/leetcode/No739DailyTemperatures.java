package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/daily-temperatures/">https://leetcode.com/problems/daily-temperatures/</a>
 * @author wzx
 */
public class No739DailyTemperatures {

  /**
   * 单调栈
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] dailyTemperatures(int[] T) {
    int[] res = new int[T.length];
    // 栈中存放索引
    Deque<Integer> stack = new LinkedList<>();
    // 从后往前遍历, 栈内元素单调递减
    for (int i = T.length - 1; i >= 0; i--) {
      int t = T[i];
      // 保证当前元素为栈内最小元素
      while (!stack.isEmpty() && T[stack.peekFirst()] <= t) {
        stack.removeFirst();
      }
      // 索引相差为距离
      res[i] = stack.isEmpty() ? 0 : stack.peekFirst() - i;
      stack.addFirst(i);
    }

    return res;
  }
}
