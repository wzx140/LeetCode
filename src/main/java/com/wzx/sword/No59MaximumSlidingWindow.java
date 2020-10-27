package com.wzx.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @author wzx
 */
public class No59MaximumSlidingWindow {

  /**
   * 单调队列
   * <p>
   * time: O(n)
   * space: O(k)
   */
  @SuppressWarnings("ConstantConditions")
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0) return new int[0];

    int[] res = new int[nums.length - k + 1];
    Deque<Integer> queue = new LinkedList<>();

    // 未形成窗口
    for (int i = 0; i < k; i++) {
      // 删除队列中比当前小的元素，保持单调性
      while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.removeLast();
      queue.addLast(nums[i]);
    }
    res[0] = queue.peekFirst();
    // 窗口滑动
    for (int i = k; i < nums.length; i++) {
      // 队列是按照数组顺序排列的，所以第一个元素可能是要滑出的元素
      if (!queue.isEmpty() && queue.peekFirst() == nums[i - k]) queue.removeFirst();
      // 删除队列中比当前小的元素，保持单调性
      while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.removeLast();
      queue.addLast(nums[i]);
      res[i - k + 1] = queue.peekFirst();
    }

    return res;
  }
}
