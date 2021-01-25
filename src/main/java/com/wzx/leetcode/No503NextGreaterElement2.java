package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/next-greater-element-ii/">https://leetcode.com/problems/next-greater-element-ii/</a>
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
      int num = nums[i];
      while (!stack.isEmpty() && num >= stack.peekFirst()){
        stack.removeFirst();
      }
      stack.addFirst(num);
    }

    // 遍历当前数组
    for (int i = nums.length - 1; i >= 0; i--) {
      int num = nums[i];
      while (!stack.isEmpty() && num >= stack.peekFirst()){
        stack.removeFirst();
      }
      res[i] = stack.isEmpty() ? -1 : stack.peekFirst();
      stack.addFirst(num);
    }

    return res;
  }
}
