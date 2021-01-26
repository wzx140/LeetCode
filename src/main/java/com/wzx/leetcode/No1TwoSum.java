package com.wzx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/two-sum/">https://leetcode.com/problems/two-sum/</a>
 * @author wzx
 */
public class No1TwoSum {

  /**
   * 哈希表
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] twoSum(int[] nums, int target) {
    // 倒排索引
    Map<Integer, Integer> invertedIndex = new HashMap<>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      int remain = target - nums[i];
      if (invertedIndex.containsKey(remain) && invertedIndex.get(remain) != i) {
        return new int[]{invertedIndex.get(remain), i};
      } else {
        invertedIndex.put(nums[i], i);
      }
    }
    return new int[]{0, 0};
  }
}
