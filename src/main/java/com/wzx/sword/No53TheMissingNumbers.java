package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/">https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/</a>
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
    int start = 0, end = nums.length - 1;
    while(start < end){
      int middle = (end - start) / 2 + start;
      if(nums[middle] == middle){
        // 缺失元素在[middle + 1, end]
        start = middle + 1;
      }else{
        // 缺失元素在[start, middle]
        end = middle;
      }
    }
    // 缺失最后一个元素
    if(nums[start] == start) return start + 1;
    return start;
  }
}
