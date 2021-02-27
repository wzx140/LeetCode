package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/first-missing-positive/">https://leetcode.com/problems/first-missing-positive/</a>
 */
public class No41FirstMissingPositive {

  /**
   * 最小正整数在[1, n+1]内, 标记数组中所有[1, n]的元素, 不需关注范围之外的元素所以改写为大于n的任意整数
   * 缺失的元素即为最小正整数, 若都出现则n+1为缺失元素
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    // 范围之外的元素所以改写为n+1
    for (int i = 0; i < n; i++) {
      if (nums[i] < 1 || nums[i] > n) {
        nums[i] = n + 1;
      }
    }
    // 标记[1, n]的正整数
    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]);
      if (num >= 1 && num <= n) {
        if (nums[num - 1] > 0) nums[num - 1] = -nums[num - 1];
      }
    }
    // 找到未出现的最小正整数
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) return i + 1;
    }
    return n + 1;
  }
}
