package com.wzx.leetcode;

import java.util.PriorityQueue;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">https://leetcode.com/problems/kth-largest-element-in-an-array/</a>
 */
public class No215KthLargestElementInAnArray {

  /**
   * 堆排序
   * <p>
   * time: O(nlogk)
   * space: O(k)
   */
  public int findKthLargest1(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int num : nums) {
      queue.add(num);
      // 堆中只留k个元素, 较小的都删除
      if (queue.size() > k) queue.remove();
    }

    return queue.peek();
  }

  /**
   * 快排思想
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int findKthLargest2(int[] nums, int k) {
    helper(nums, 0, nums.length - 1, k - 1);

    return nums[k - 1];
  }

  private void helper(int[] nums, int start, int end, int k) {
    // 快排
    if (start >= end) return;

    int pivot = (end - start) / 2 + start;
    int record = nums[pivot];
    int left = start, right = end;
    nums[pivot] = nums[right];
    while (left < right) {
      while (left < right && nums[left] > record) left++;
      if (left < right) {
        nums[right--] = nums[left];
      }
      while (left < right && nums[right] < record) right--;
      if (left < right) {
        nums[left++] = nums[right];
      }
    }
    nums[left] = record;
    // 根据轴值左侧个数递归排序
    int leftNum = left - start;
    if (leftNum > k) {
      // 继续划分左侧
      helper(nums, start, left - 1, k);
    } else if (leftNum < k) {
      // 已经提取出来前leftNum个元素, 继续从右侧提取k-leftNum-1
      helper(nums, left + 1, end, k - leftNum - 1);
    }
  }
}
