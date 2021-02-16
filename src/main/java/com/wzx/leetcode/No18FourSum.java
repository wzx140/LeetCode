package com.wzx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/4sum/">https://leetcode.com/problems/4sum/</a>
 */
public class No18FourSum {

  /**
   * 左右指针, 类比No15ThreeSum
   * <p>
   * time: O(n^3)
   * space: O(n)
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);

    List<List<Integer>> res = new LinkedList<>();
    // 固定两个元素
    for (int i = 0; i < nums.length - 3; i++) {
      // three sum
      for (int j = i + 1; j < nums.length - 2; j++) {
        // two sum
        int object = target - nums[i] - nums[j];
        int left = j + 1, right = nums.length - 1;
        while (left < right) {
          int sum = nums[left] + nums[right];
          if (sum > object) {
            right--;
            // 跳过重复元素
            while (left < right && nums[right] == nums[right + 1]) right--;
          } else if (sum < object) {
            left++;
            // 跳过重复元素
            while (left < right && nums[left] == nums[left - 1]) left++;
          } else {
            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            left++;
            right--;
            // 跳过重复元素
            while (left < right && nums[right] == nums[right + 1]) right--;
            while (left < right && nums[left] == nums[left - 1]) left++;
          }

        }
        // 跳过重复元素
        while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
      }
      // 跳过重复元素
      while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
    }
    return res;
  }
}
