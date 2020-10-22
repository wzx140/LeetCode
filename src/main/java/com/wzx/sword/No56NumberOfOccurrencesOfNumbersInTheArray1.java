package com.wzx.sword;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * @author wzx
 */
public class No56NumberOfOccurrencesOfNumbersInTheArray1 {

  /**
   * 先排序再寻找相邻不重复的元素
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int[] singleNumbers1(int[] nums) {
    Arrays.sort(nums);
    int index = 0;
    int[] res = new int[2];

    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      if (i < nums.length - 1 && nums[i] == nums[i + 1]) continue;

      res[index++] = nums[i];
      if (index == 2) break;
    }

    return res;
  }

  /**
   * 两个数字异或，相同的数位为0，不相同的为1。所以数组所有元素异或的结果就是两个不相同元素异或的结果
   * 分组异或：将两个不重复数字分成两组进行分别异或
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int[] singleNumbers2(int[] nums) {
    // 所有数字的异或
    int Xor = Arrays.stream(nums).reduce((x, y) -> x ^ y).orElse(0);
    // 寻找两个不相同元素不同的数位，即寻找为1的数位
    int mask = 1;
    while ((Xor & mask) == 0) {
      mask <<= 1;
    }
    // 根据不同的数位进行分组异或
    int a = 0, b = 0;
    for (int num : nums) {
      if ((num & mask) == 0) {
        a ^= num;
      } else {
        b ^= num;
      }
    }

    return new int[]{a, b};
  }
}
