package com.wzx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 *
 * @author wzx
 */
public class No18FourSum {

  /**
   * 左右指针
   *
   * time: O(n^3)
   * space: O(n)
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new LinkedList<>();

    // 在3sum上再包裹一层循环
    for (int i = 0; i < nums.length - 3; i++) {
      // 防止重复，第一个数和前一个搜索值重复
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      for (int j = i + 1; j < nums.length - 2; j++) {
        // 防止重复，第二个数和前一个搜索值重复
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;

        int left = j + 1, right = nums.length - 1;
        while (left < right) {
          // 防止重复，第三个数和前一个搜索值重复
          if (left > j + 1 && nums[left] == nums[left - 1]){
            left++;
            continue;
          }

          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum > target) {
            right--;
          } else if (sum < target) {
            left++;
          } else {
            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            left++;
          }
        }
      }
    }

    return res;
  }
}
