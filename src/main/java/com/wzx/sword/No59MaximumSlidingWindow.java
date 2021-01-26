package com.wzx.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/">https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/</a>
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
    // 单调队列，队列元素单调递减，所以队首是滑动窗口的最大值
    Deque<Integer> queue = new LinkedList<>();
    // 初始化窗口
    for (int i = 0; i < k; i++) {
      int num = nums[i];
      // 比当前元素小的出队
      while (!queue.isEmpty() && queue.peekLast() < num) {
        queue.removeLast();
      }
      queue.addLast(num);
    }
    res[0] = queue.peekFirst();
    // 移动窗口
    for (int i = k; i < nums.length; i++) {
      int numAdd = nums[i];
      int numDel = nums[i - k];
      // 删除元素，维护单调队列
      if (queue.peekFirst() == numDel) queue.removeFirst();
      // 添加元素，维护单调队列，与初始化窗口的操作一致
      while (!queue.isEmpty() && queue.peekLast() < numAdd) {
        queue.removeLast();
      }
      queue.addLast(numAdd);
      res[i - k + 1] = queue.peekFirst();
    }

    return res;
  }
}
