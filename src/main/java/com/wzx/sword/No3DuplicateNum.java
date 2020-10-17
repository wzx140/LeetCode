package com.wzx.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @author wzx
 */
public class No3DuplicateNum {

  /**
   * 先排序再查找
   *
   * time: O(nlogn)
   * space: O(1)
   */
  public int findRepeatNumber1(int[] nums) {
    Arrays.sort(nums);

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        return nums[i];
      }
    }

    return -1;
  }

  /**
   * 哈希表
   *
   * time: O(n)
   * space: O(n)
   */
  public int findRepeatNumber2(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      if (numSet.contains(num)) {
        return num;
      } else {
        numSet.add(num);
      }
    }

    return -1;
  }

  /**
   * 由于数字在0~n-1之间，以数组下标作为标记，可以作为重复判断的依据。
   * 每次常数时间复杂度内都可以将某一元素放到正确的位置，所以最差情况下时间复杂度为O(n)
   *
   * time: O(n)
   * space: O(1)
   */
  public int findRepeatNumber3(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      // 重复直到当前下标与值对应
      while (i != nums[i]) {
        int num = nums[i];
        if (num == nums[num]) {
          return num;
        } else {
          // 当前下标的值移动到它应该在的下标位置
          nums[i] = nums[num];
          nums[num] = num;
        }
      }
    }

    return -1;
  }
}
