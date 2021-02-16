package com.wzx.leetcode;

import java.util.*;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/3sum/">https://leetcode.com/problems/3sum/</a>
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
    // 固定其中一个元素
    for (int i = 0; i < nums.length - 2; i++) {
      // two sum
      int target = -nums[i];
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum > target) {
          right--;
          // 跳过重复元素
          while (left < right && nums[right] == nums[right + 1]) right--;
        } else if (sum < target) {
          left++;
          // 跳过重复元素
          while (left < right && nums[left] == nums[left - 1]) left++;
        } else {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
          // 跳过重复元素
          while (left < right && nums[right] == nums[right + 1]) right--;
          while (left < right && nums[left] == nums[left - 1]) left++;
        }

      }
      // 跳过重复元素
      while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
    }
    return res;
  }
}
