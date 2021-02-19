package com.wzx.leetcode;

import java.util.Random;

/**
 * @see <a href="https://leetcode.com/problems/random-pick-index/">https://leetcode.com/problems/random-pick-index/</a>
 * @author wzx
 */
public class No398RandomPickIndex {

  private final int[] nums;
  private final Random rand = new Random();

  public No398RandomPickIndex(int[] nums) {
    this.nums = nums;
  }

  /**
   * 水塘抽样
   *
   * time: O(n)
   * space: O(1)
   */
  public int pick(int target) {
    int res = 0;
    int cnt = 0;

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num == target && rand.nextInt(++cnt) < 1) {
        res = i;
      }
    }

    return res;
  }
}
