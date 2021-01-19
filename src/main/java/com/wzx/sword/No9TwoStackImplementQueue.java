package com.wzx.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/">https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/</a>
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
      stack1.addFirst(value);
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
          stack2.addFirst(stack1.pollFirst());
        }
      }
      return stack2.isEmpty() ? -1 : stack2.pollFirst();
    }
  }
}
