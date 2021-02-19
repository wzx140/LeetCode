package com.wzx.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wzx
 * @see <a href="https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/">https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/</a>
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
    int numZero = 0;
    int diff = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        numZero++;
      } else if (i > 0 && nums[i - 1] != 0) {
        // 重复不能构成顺子
        if (nums[i] == nums[i - 1]) return false;
        // 顺子间的差距
        diff += nums[i] - nums[i - 1] - 1;
      }
    }

    return diff - numZero <= 0;
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
