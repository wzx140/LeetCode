package com.wzx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 *
 * @author wzx
 */
public class No15ThreeSum {


  /**
   * 在two sum的基础上套n-2层循环就是nsum解
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new LinkedList<>();
    // 跳过重复的元素
    for (int i = 0; i < nums.length - 2; i++) {
      // two sum的结果加上当前元素即是3sum的解
      List<List<Integer>> solutions = twoSumTarget(nums, i + 1, -nums[i]);
      for (List<Integer> solution : solutions) {
        solution.add(0, nums[i]);
      }
      res.addAll(solutions);
      // 防止重复，第一个数和前一个搜索值重复
      while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
    }

    return res;
  }

  /**
   * [start, end]内求出多组不重复two sum解的一般解决方法(左右指针)
   */
  public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
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
