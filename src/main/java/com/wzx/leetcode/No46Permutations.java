package com.wzx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 *
 * @author wzx
 */
public class No46Permutations {

  /**
   * 回溯
   * <p>
   * time: O(n!)
   * space: O(n)
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    recursion(nums, new LinkedList<>(), res);

    return res;
  }

  private void recursion(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {
    if (track.size() == nums.length) {
      res.add(new LinkedList<>(track));
      return;
    }

    for (int num : nums) {
      // 每次添加未访问的元素
      if (!track.contains(num)) {
        track.add(num);
        recursion(nums, track, res);
        track.removeLast();
      }
    }
  }
}
