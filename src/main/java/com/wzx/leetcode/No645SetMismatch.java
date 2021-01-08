package com.wzx.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/set-mismatch/">https://leetcode.com/problems/set-mismatch/</a>
 * @author wzx
 */
public class No645SetMismatch {

  /**
   * 哈希表
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] findErrorNums1(int[] nums) {
    Set<Integer> map = new HashSet<>();
    int[] res = new int[2];
    for (int num : nums) {
      if (map.contains(num)) res[0] = num;
      map.add(num);
    }
    for (int i = 1; i <= nums.length; i++) {
      if (!map.contains(i)) res[1] = i;
    }
    return res;
  }

  /**
   * 用value的符号位代替哈希表, 类似No448FindAllNumbersDisappearedInAnArray
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int[] findErrorNums2(int[] nums) {
    int[] res = new int[2];
    // 重复
    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] > 0) {
        nums[index] *= -1;
      } else {
        res[0] = index + 1;
      }
    }
    // 缺失
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) res[1] = i + 1;
    }
    return res;
  }
}
