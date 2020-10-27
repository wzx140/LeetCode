package com.wzx.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * @author wzx
 */
public class No59MaximumValueOfTheQueue {

  /**
   * 单调队列
   *
   * time: O(1)
   * space: O(n)
   */
  public static class MaxQueue {
    private final Deque<Integer> maxQueue;
    private final Deque<Integer> queue;

    public MaxQueue() {
      maxQueue = new LinkedList<>();
      queue = new LinkedList<>();
    }

    public int max_value() {
      return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    public void push_back(int value) {
      // 因为从尾部添加，从头部删除，所以从尾部开始比当前元素小的都对最大值没有影响
      while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) maxQueue.removeLast();
      maxQueue.addLast(value);
      queue.addLast(value);
    }

    @SuppressWarnings("ConstantConditions")
    public int pop_front() {
      if (queue.isEmpty()) {
        return -1;
      } else {
        int popValue = queue.removeFirst();
        if (popValue == maxQueue.peekFirst()) maxQueue.removeFirst();
        return popValue;
      }
    }
  }
}
