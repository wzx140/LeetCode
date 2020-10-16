package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author wzx
 */
public class No34FindFirstAndLastPositionOfElementInSortedArray {

  /**
   * 二分搜索
   *
   * time: O(logn)
   * space: O(1)
   */
  public int[] searchRange(int[] nums, int target) {
    // 二分搜索上界
    int upper = -1;
    // 搜索区间 [start, end)
    int start = 0;
    int end = nums.length;
    while (start < end) {
      int middle = (end - start) / 2 + start;

      if (nums[middle] <= target) {
        start = middle + 1;
      } else {
        end = middle;
      }

    }
    if (end >= 1 && nums[end - 1] == target) upper = end - 1;

    // 二分搜索下界
    int lower = -1;
    // 搜索区间 [start, end)
    start = 0;
    end = nums.length;
    while (start < end) {
      int middle = (end - start) / 2 + start;

      if (nums[middle] < target) {
        start = middle + 1;
      } else {
        end = middle;
      }
    }
    if (start < nums.length && nums[start] == target) lower = start;

    return new int[]{lower, upper};
  }
}
