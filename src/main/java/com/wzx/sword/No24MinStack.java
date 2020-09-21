package com.wzx.sword;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49
 *
 * @author wzx
 */
public class No24MinStack {

  private final Deque<Integer> stack = new LinkedList<>();

  /**
   * 辅助栈，保存stack每个栈帧所处状态的最小值
   */
  private final Deque<Integer> minStack = new LinkedList<>();

  public void push(int node) {
    stack.push(node);
    if (!minStack.isEmpty() && minStack.peek() < node) {
      minStack.push(minStack.peek());
    } else {
      minStack.push(node);
    }
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  @SuppressWarnings("ConstantConditions")
  public int top() {
    return stack.peek();
  }

  @SuppressWarnings("ConstantConditions")
  public int min() {
    return minStack.peek();
  }
}
