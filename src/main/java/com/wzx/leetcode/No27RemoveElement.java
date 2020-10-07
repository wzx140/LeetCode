package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/remove-element/
 *
 * @author wzx
 */
public class No27RemoveElement {

  /**
   * 双指针，快慢指针
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int removeElement1(int[] nums, int val) {
    // 用于存储的索引
    int slow = 0;
    // 用于遍历检测目标值的索引
    int fast = 0;

    for (; fast < nums.length; fast++) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
    }

    return slow;
  }

  /**
   * 双指针，如果大多数元素不是val则方法二快，如果大多数元素是val则方法一快
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int removeElement2(int[] nums, int val) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      if (nums[left] == val) {
        nums[left] = nums[right];
        right--;
      } else {
        left++;
      }
    }

    return left;
  }
}
