package com.wzx.sword;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6
 *
 * @author wzx
 */
public class No8TwoStackImplementQueue {

  public static class MockQueue {
    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2 = new ArrayDeque<>();

    /**
     * time: O(1)
     * space: O(1)
     */
    public void push(int node) {
      stack1.push(node);
    }

    /**
     * 放入另外一个栈，再取出
     * <p>
     * time: O(n)
     * space: O(1)
     */
    public int pop() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }

      return stack2.pop();
    }
  }
}
