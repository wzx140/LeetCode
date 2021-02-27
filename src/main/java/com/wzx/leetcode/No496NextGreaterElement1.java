package com.wzx.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/next-greater-element-i/">https://leetcode.com/problems/next-greater-element-i/</a>
 */
public class No496NextGreaterElement1 {

  /**
   * 利用单调栈先求出元素与next greater numbers的映射关系
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length];
    Map<Integer, Integer> map = new HashMap<>(nums2.length);
    Deque<Integer> stack = new LinkedList<>();

    // 从后往前遍历, 栈内元素始终保持单调递减
    for (int i = nums2.length - 1; i >= 0; i--) {
      int num = nums2[i];
      // 保证栈内元素都比当前元素大
      while (!stack.isEmpty() && num >= stack.peekFirst()) stack.removeFirst();
      // 栈顶的一个就是下一个更大元素
      if (!stack.isEmpty()) map.put(num, stack.peekFirst());
      stack.addFirst(num);
    }

    for (int i = 0; i < nums1.length; i++) {
      res[i] = map.getOrDefault(nums1[i], -1);
    }

    return res;
  }
}
