package com.wzx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 *
 * @author wzx
 */
public class No15ThreeSum {

  /**
   * 哈希表
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public List<List<Integer>> threeSum1(int[] nums) {
    Map<Integer, Integer> numCnt = new HashMap<>();
    Arrays.stream(nums).forEach(x -> numCnt.merge(x, 1, Integer::sum));

    // 防止重复，使用set
    Set<List<Integer>> resSet = new HashSet<>();

    // 先确定一个数，再使用2sum的哈希表方法
    for (int i = 0; i < nums.length - 2; i++) {
      int remain2 = -nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        int remain1 = remain2 - nums[j];
        if (numCnt.getOrDefault(remain1, 0) != 0) {
          // 防止重复添加数字
          int dupDegree = 1;
          if (remain1 == nums[j]) dupDegree++;
          if (remain1 == nums[i]) dupDegree++;
          if (numCnt.get(remain1) < dupDegree) continue;

          // 防止重复,排序数组
          List<Integer> res = Arrays.asList(nums[i], remain1, nums[j]);
          Collections.sort(res);
          resSet.add(res);
        }
      }
    }

    return new ArrayList<>(resSet);
  }

  /**
   * 左右指针
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public List<List<Integer>> threeSum2(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new LinkedList<>();

    // 先确定一个数，再使用2sum的左右指针
    for (int i = 0; i < nums.length - 2; i++) {
      // 防止重复，第一个数和前一个搜索值重复
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      int remain2 = -nums[i];
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        // 防止重复，防止第二个数和前一个搜索值重复
        if (left > i + 1 && nums[left] == nums[left - 1]){
          left++;
          continue;
        }

        int sum = nums[left] + nums[right];
        if (sum > remain2) {
          right--;
        } else if (sum < remain2) {
          left++;
        } else {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          // 两个数固定，那么第三数一定已经确定了
          left++;
        }
      }
    }

    return res;
  }
}
