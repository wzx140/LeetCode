package com.wzx.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 *
 * @author wzx
 */
public class No16ThreeSumClosest {

  /**
   * 左右指针
   *
   * time: O(n^2)
   * space: O(1)
   */
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int delta = Integer.MAX_VALUE;

    // 先确定一个数，再使用2sum的左右指针
    for (int i = 0; i < nums.length; i++) {

      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        // 更新最接近的值
        if (Math.abs(delta) > Math.abs(sum - target)) delta = sum - target;
        if (sum > target) {
          right--;
        } else if (sum < target) {
          left++;
        } else {
          return target;
        }
      }
    }

    return delta + target;
  }
}
