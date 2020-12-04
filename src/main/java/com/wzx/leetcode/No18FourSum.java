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
   * 左右指针, 类比No15ThreeSum
   * <p>
   * time: O(n^3)
   * space: O(n)
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new LinkedList<>();

    // 在3sum上再包裹一层循环
    for (int i = 0; i < nums.length - 3; i++) {
      for (int j = i + 1; j < nums.length - 2; j++) {
        List<List<Integer>> solutions = twoSumTarget(nums, j + 1, target - nums[i] - nums[j]);
        for (List<Integer> solution : solutions) {
          solution.add(0, nums[j]);
          solution.add(0, nums[i]);
        }
        res.addAll(solutions);
        // 跳过重复的元素
        while (j < nums.length - 2 && nums[j + 1] == nums[j]) j++;
      }
      // 跳过重复的元素
      while (i < nums.length - 3 && nums[i + 1] == nums[i]) i++;
    }

    return res;
  }


  /**
   * 类比No15ThreeSum
   */
  private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
    int left = start, right = nums.length - 1;
    List<List<Integer>> res = new LinkedList<>();
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum > target) {
        right--;
        // 跳过重复的元素
        while (left < right && nums[right] == nums[right + 1]) right--;
      } else if (sum < target) {
        left++;
        // 跳过重复的元素
        while (left < right && nums[left] == nums[left - 1]) left++;
      } else {
        // 找到two sum
        List<Integer> solution = new LinkedList<>();
        solution.add(nums[left]);
        solution.add(nums[right]);
        res.add(solution);
        left++;
        right--;
        // 跳过重复的元素
        while (left < right && nums[left] == nums[left - 1]) left++;
        while (left < right && nums[right] == nums[right + 1]) right--;
      }
    }
    return res;
  }
}
