package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 * @author wzx
 */
public class No503NextGreaterElement2 {

  /**
   * 先拓展数组，再使用单调栈
   *
   * time: O(n)
   * space: O(n)
   */
  public int[] nextGreaterElements(int[] nums) {
    Deque<Integer> stack = new LinkedList<>();
    int[] res = new int[nums.length];

    // 先遍历拓展的数组
    for (int i = nums.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[i] > stack.peek()) stack.pop();
      stack.push(nums[i]);
    }

    // 遍历当前数组
    for (int i = nums.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[i] >= stack.peek()) stack.pop();
      res[i] = stack.peek() == null ? -1 : stack.peek();
      stack.push(nums[i]);
    }

    return res;
  }
}
