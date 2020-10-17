package com.wzx.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6
 *
 * @author wzx
 */
public class No9TwoStackImplementQueue {

  public static class CQueue {
    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;

    public CQueue() {
      stack1 = new LinkedList<>();
      stack2 = new LinkedList<>();
    }

    /**
     * time: O(1)
     * space: O(1)
     */
    public void appendTail(int value) {
      stack1.push(value);
    }

    /**
     * 放入另外一个栈，再取出
     * <p>
     * time: O(n)
     * space: O(1)
     */
    public int deleteHead() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }

      return stack2.isEmpty() ? -1 : stack2.pop();
    }

    public void clear(){
      stack1.clear();
      stack2.clear();
    }
  }
}
