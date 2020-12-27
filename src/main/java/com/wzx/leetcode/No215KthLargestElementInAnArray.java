package com.wzx.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * @author wzx
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
   * 部分快排+二分搜索
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int findKthLargest2(int[] nums, int k) {
    int left = 0, right = nums.length - 1;
    // 第k大即第nums.length - k+1小
    k = nums.length - k;
    // 二分搜索
    while (left < right) {
      int pivot = partition(nums, left, right);
      if (pivot > k) {
        right = pivot - 1;
      } else if (pivot < k) {
        left = pivot + 1;
      } else {
        return nums[k];
      }
    }

    return nums[left];
  }

  private int partition(int[] nums, int left, int right) {
    // 快排的想法
    int pivot = left + (right - left) / 2;
    int record = nums[pivot];

    nums[pivot] = nums[right];
    while (left < right) {
      while (nums[left] < record && left < right) left++;
      if (left < right) nums[right--] = nums[left];
      while (nums[right] > record && left < right) right--;
      if (left < right) nums[left++] = nums[right];
    }
    nums[left] = record;

    // 返回排序后的轴值索引
    return left;
  }
}
