package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/</a>
 */
public class No34FindFirstAndLastPositionOfElementInSortedArray {

  /**
   * 二分搜索
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public int[] searchRange(int[] nums, int target) {
    int lowerIndex = lower(nums, target);
    int upperIndex = upper(nums, target);

    return new int[]{lowerIndex, upperIndex};
  }

  private int lower(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int middle = (end - start) / 2 + start;
      if (nums[middle] < target) {
        start = middle + 1;
      } else if (nums[middle] > target) {
        end = middle - 1;
      } else {
        end = middle - 1;
      }
    }

    if (start < nums.length && nums[start] == target) {
      return start;
    } else {
      return -1;
    }
  }

  private int upper(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    while (start <= end) {
      int middle = (end - start) / 2 + start;
      if (nums[middle] < target) {
        start = middle + 1;
      } else if (nums[middle] > target) {
        end = middle - 1;
      } else {
        start = middle + 1;
      }
    }

    if (end >= 0 && nums[end] == target) {
      return end;
    } else {
      return -1;
    }
  }
}
