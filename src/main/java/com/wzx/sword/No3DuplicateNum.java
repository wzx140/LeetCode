package com.wzx.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/</a>
 * @author wzx
 */
public class No3DuplicateNum {

  /**
   * 先排序再查找
   * <p>
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
   * <p>
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
   * 由于数字在0~n-1之间，以符号位替代哈希表记录已经出现的数字
   * 对于0替换为n作为特殊处理
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int findRepeatNumber3(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int num = Math.abs(nums[i]);
      // 0替换为n
      if (num == nums.length) num = 0;
      if (nums[num] < 0) return num;

      if (nums[num] == 0) {
        // 0替换为n
        nums[num] = -nums.length;
      } else {
        nums[num] = -nums[num];
      }
    }
    return -1;
  }
}
