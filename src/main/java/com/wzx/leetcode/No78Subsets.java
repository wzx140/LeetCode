package com.wzx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/subsets/">https://leetcode.com/problems/subsets/</a>
 * @author wzx
 */
public class No78Subsets {

  private List<List<Integer>> res = null;

  /**
   * 回溯
   * <p>
   * time: O(A_n^k*k), clone=O(k)
   * space: O(n)
   */
  public List<List<Integer>> subsets(int[] nums) {
    res = new LinkedList<>();
    recursion(nums, 0, new LinkedList<>());
    return res;
  }

  private void recursion(int[] nums, int start, LinkedList<Integer> track) {
    // 全部子集
    res.add(new LinkedList<>(track));

    for (int i = start; i < nums.length; i++) {
      track.add(nums[i]);
      recursion(nums, i + 1, track);
      track.removeLast();
    }
  }
}
