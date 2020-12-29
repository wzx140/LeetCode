package com.wzx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author wzx
 */
public class No448FindAllNumbersDisappearedInAnArray {

  /**
   * 排序
   * <p>
   * time: O(nlogn)
   * space: O(1)
   */
  public List<Integer> findDisappearedNumbers1(int[] nums) {
    Arrays.sort(nums);
    List<Integer> res = new LinkedList<>();
    if (nums.length == 0) return res;
    // 头部缺失
    for (int j = 1; j < nums[0]; j++) {
      res.add(j);
    }
    // 中间缺失
    for (int i = 1; i < nums.length; i++) {
      // 相差大于1说明缺失数字
      if (nums[i] - nums[i - 1] > 1) {
        for (int j = nums[i - 1] + 1; j < nums[i]; j++) {
          res.add(j);
        }
      }
    }
    // 尾部缺失
    for (int j = nums[nums.length - 1] + 1; j <= nums.length; j++) {
      res.add(j);
    }

    return res;
  }

  /**
   * 利用哈希表
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public List<Integer> findDisappearedNumbers2(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    List<Integer> res = new LinkedList<>();
    for (int i = 1; i <= nums.length; i++) {
      if (!set.contains(i)) res.add(i);
    }
    return res;
  }

  /**
   * index+1与value是一一对应的关系, 利用value的符号位代替哈希表
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public List<Integer> findDisappearedNumbers3(int[] nums) {
    // value-1的index符号位作为哈希表, 储存value存在信息
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] > 0) nums[index] *= -1;
    }
    List<Integer> res = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) res.add(i + 1);
    }

    return res;
  }
}
