package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * @author wzx
 */
public class No42TrappingRainWater {

  /**
   * 当前位置的最大盛水量为: min(max_left, max_right)-cur
   */

  /**
   * 先缓存左右最大值再计算
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int trap1(int[] height) {
    if (height.length == 0) return 0;

    int length = height.length;
    int[] maxLeft = new int[length];
    int[] maxRight = new int[length];

    // 缓存左右最大值
    maxLeft[0] = height[0];
    for (int i = 1; i < length; i++) {
      maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
    }
    maxRight[length - 1] = height[length - 1];
    for (int i = length - 2; i >= 0; i--) {
      maxRight[i] = Math.max(maxRight[i + 1], height[i]);
    }

    int sum = 0;
    for (int i = 0; i < length; i++) {
      sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
    }

    return sum;
  }

  /**
   * 左右指针
   *
   * time: O(n)
   * space: O(1)
   */
  public int trap2(int[] height) {
    int maxLeft = 0, maxRight = 0;
    int left = 0, right = height.length - 1;

    int sum = 0;
    while (left <= right) {
      // 更新最大值
      maxLeft = Math.max(maxLeft, height[left]);
      maxRight = Math.max(maxRight, height[right]);

      // 在left处, 左边最大值为maxLeft, 右边最大值大于maxRight
      // maxLeft<maxRight<=右边最大值
      if (maxLeft < maxRight) {
        sum += maxLeft - height[left];
        left++;
      } else {
        // 在right处, 右最大值为maxRight, 左边最大值大于maxLeft
        // maxRight<maxLeft<=左边最大值
        sum += maxRight - height[right];
        right--;
      }
    }

    return sum;
  }
}
