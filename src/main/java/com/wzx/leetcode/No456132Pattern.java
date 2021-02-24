package com.wzx.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/132-pattern/">https://leetcode.com/problems/132-pattern/</a>
 */
public class No456132Pattern {

  public boolean find132pattern(int[] nums) {
    if (nums.length < 3) return false;
    // 最小值数组
    int[] min = new int[nums.length];
    min[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      min[i] = Math.min(nums[i], min[i - 1]);
    }
    // 递减栈, 栈顶是最小值
    Deque<Integer> stack = new LinkedList<>();
    // 需要找到 i1 < i < i2, 使得min[i1] < stack[i2] < nums[i]
    for (int i = nums.length - 1; i >= 1; i--) {
      // 已知min[i1], nums[i] 求stack[i2]
      if (nums[i] > min[i - 1]) {
        // 弹出比min[i1]还小的元素
        while (!stack.isEmpty() && stack.peekFirst() <= min[i - 1]) stack.removeFirst();
        if (!stack.isEmpty() && stack.peekFirst() < nums[i]) return true;
        // nums[i]大于栈顶元素, 所以可以保持栈的单调性
        stack.addFirst(nums[i]);
      }
    }
    return false;
  }
}
