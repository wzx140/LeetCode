package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @author wzx
 */
public class No21AdjustArrayOrder {

  /**
   * 双指针交换
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public void exchange(int[] nums) {
    int oddIndex = 0;
    int evenIndex = nums.length - 1;

    while (oddIndex < evenIndex) {
      // 找到前半部分的偶数
      while (oddIndex < evenIndex && (nums[oddIndex] & 1) != 0) oddIndex++;
      // 找到后半部分的奇数
      while (oddIndex < evenIndex && (nums[evenIndex] & 1) != 1) evenIndex--;
      // 交换
      if (oddIndex < evenIndex) {
        int tmp = nums[oddIndex];
        nums[oddIndex] = nums[evenIndex];
        nums[evenIndex] = tmp;
      }
    }
  }
}
