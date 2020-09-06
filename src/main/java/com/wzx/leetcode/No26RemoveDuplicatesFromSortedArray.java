package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author wzx
 */
public class No26RemoveDuplicatesFromSortedArray {

  /**
   * 快慢指针
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int removeDuplicates(int[] nums) {
    // 当前存储位置
    int slow = 1;
    // 当前对比位置
    int fast = 0;

    for (fast = 1; fast < nums.length; fast++) {
      if (nums[fast] != nums[fast - 1]) {
        nums[slow] = nums[fast];
        slow++;
      }
    }

    return slow;
  }
}
