package com.wzx.sword;

/**
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 *
 * @author wzx
 */
public class No53TheMissingNumbers {

  /**
   * 遍历
   * <p>
   * time: O(n)
   * space: O(1)
   */
  public int missingNumber1(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums[0] != 0) return 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] > 1) return nums[i] - 1;
    }

    return nums.length;
  }

  /**
   * 二分搜索
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public int missingNumber2(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums[0] != 0) return 0;
    if (nums[nums.length - 1] != nums.length) return nums.length;

    // begin和end趋向于缺失数字的右边一个元素
    int begin = 0, end = nums.length - 1;
    while (begin < end) {
      int middle = (end - begin) / 2 + begin;
      if (nums[middle] == middle) {
        begin = middle + 1;
      } else {
        end = middle;
      }
    }

    return nums[begin] - 1;
  }

  /**
   * 二分搜索
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public int missingNumber3(int[] nums) {
    // 划分左数组和右数组
    // 左数组的末尾元素nums[i]=i
    // 右数组的开始元素nums[i]=i+1
    int begin = 0, end = nums.length - 1;
    while (begin <= end) {
      int middle = (end - begin) / 2 + begin;
      if (nums[middle] == middle) {
        // 右数组的开始元素在[middle+1, end]
        begin = middle + 1;
      } else {
        // 左数组的结尾元素在[0, middle-1]
        end = middle - 1;
      }
    }
    // 返回右数组开始元素索引
    return begin;
  }
}
