package com.wzx.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 *
 * @author wzx
 */
public class No61StraightInPlayingCards {

  /**
   * 先排序再遍历
   * <p>
   * time: O(nlogn)
   * space: O(1)
   */
  public boolean isStraight1(int[] nums) {
    Arrays.sort(nums);
    // 统计大小王个数
    int zero = 0;
    for (int num : nums) {
      if (num == 0) zero++;
      else break;
    }

    for (int i = zero + 1; i < nums.length; i++) {
      int preCard = nums[i - 1];
      int card = nums[i];
      // 不能重复
      if (card == preCard) return false;

      // 用大小王填充不连续的字符
      zero -= card - preCard - 1;
      if (zero < 0) return false;
    }

    return true;
  }

  /**
   * set判断重复，最大牌和最小牌之前相差小于4张(剩余可以被0填充)
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public boolean isStraight2(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int min = 14, max = 0;
    for (int num : nums) {
      if (num != 0) {
        // 不能重复
        if (set.contains(num)) return false;

        min = Math.min(min, num);
        max = Math.max(max, num);
        set.add(num);
      }
    }

    return max - min < 5;
  }
}
