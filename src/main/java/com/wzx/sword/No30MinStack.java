package com.wzx.sword;

import java.util.*;

/**
 * @see <a href="https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/">https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/</a>
 * @author wzx
 */
public class No30MinStack {

  /**
   * 单调栈
   * <p>
   * time: O(1)
   * space: O(n)
   */
  public static class MinStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
      stack = new LinkedList<>();
      minStack = new LinkedList<>();
    }

    public void push(int x) {
      // 新加入的元素如果不比上一个状态的最小值小，那么这个元素对目前的最小值没有影响，不用添加
      if (minStack.isEmpty() || minStack.peekFirst() >= x) minStack.addFirst(x);
      stack.addFirst(x);
    }

    @SuppressWarnings("ConstantConditions")
    public void pop() {
      int popValue = stack.pollFirst();
      if (popValue == minStack.peekFirst()) minStack.removeFirst();
    }

    @SuppressWarnings("ConstantConditions")
    public int top() {
      return stack.peekFirst();
    }

    @SuppressWarnings("ConstantConditions")
    public int min() {
      return minStack.peekFirst();
    }
  }
}
