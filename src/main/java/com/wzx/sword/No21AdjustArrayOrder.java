package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/">https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/</a>
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
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      // 找到前半部分的偶数
      while (left < right && (nums[left] & 1) != 0) left++;
      // 找到后半部分的奇数
      while (left < right && (nums[right] & 1) != 1) right--;
      // 交换
      if (left < right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
      }
    }
  }
}
