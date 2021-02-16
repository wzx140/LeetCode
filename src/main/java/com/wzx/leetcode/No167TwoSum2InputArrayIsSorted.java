package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/</a>
 * @author wzx
 */
public class No167TwoSum2InputArrayIsSorted {


  /**
   * 左右指针
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;

    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target) {
        return new int[]{left + 1, right + 1};
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return new int[]{0, 0};
  }
}
