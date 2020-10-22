package com.wzx.sword;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 *
 * @author wzx
 */
public class No56NumberOfOccurrencesOfNumbersInTheArray2 {

  /**
   * 先排序，再查找
   *
   * time: O(nlogn)
   * space: O(1)
   */
  public int singleNumber1(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      boolean preDup = i > 0 && nums[i] == nums[i - 1];
      boolean postDup = i < nums.length - 1 && nums[i] == nums[i + 1];
      if (!preDup && !postDup) return nums[i];
    }

    return 0;
  }

  /**
   * 统计所有数字每位的计数，每位mod3就是那个不相同的数
   *
   * time: O(n)
   * space: O(32)
   */
  public int singleNumber2(int[] nums) {
    // 1~32位的掩码
    int[] masks = new int[32];
    masks[0] = 1;
    for (int i = 1; i < 32; i++) {
      masks[i] = masks[i - 1] << 1;
    }

    int[] cnt = new int[32];
    for (int num : nums) {
      // 统计每个数组的32位
      for (int j = 0; j < 32; j++) {
        cnt[j] += (num & masks[j]) == 0 ? 0 : 1;
      }
    }

    int res = 0;
    // 取余3后，就是那个不相同数的每位取值
    for (int i = 0; i < 32; i++) {
      res <<= 1;
      res |= (cnt[31 - i] % 3);
    }

    return res;
  }
}
