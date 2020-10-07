package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * @author wzx
 */
public class No283MoveZeroes {

  /**
   * 双指针
   * <p>
   * time: O(n)
   * sapce: O(1)
   */
  public void moveZeroes1(int[] nums) {
    // 用于存储当前非0元素的索引
    int slow = 0;
    // 用于遍历检测0的索引
    int fast = 0;

    for (; fast < nums.length; fast++) {
      if (nums[fast] != 0) {
        nums[slow] = nums[fast];
        slow++;
      }
    }

    // 补充尾部0
    for (; slow < nums.length; slow++) {
      nums[slow] = 0;
    }
  }

  /**
   * 双指针，减少了不必要的补充0
   * <p>
   * time: O(n)
   * sapce: O(1)
   */
  public void moveZeroes2(int[] nums) {
    // 用于存储当前非0元素的索引
    int slow = 0;
    // 用于遍历检测0的索引
    int fast = 0;

    for (; fast < nums.length; fast++) {
      if (nums[fast] != 0) {
        int tmp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = tmp;
        slow++;
      }
    }
  }
}
