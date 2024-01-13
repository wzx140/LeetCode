package com.wzx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/permutations-ii/">https://leetcode.com/problems/permutations-ii/</a>
 */
public class No47Permutations2 {

  /**
   * 回溯
   * <p>
   * time: O(n!)
   * space: O(n)
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    boolean[] visit = new boolean[nums.length];
    List<List<Integer>> res = new LinkedList<>();
    recursion(nums, new LinkedList<>(), visit, res);

    return res;
  }

  private void recursion(int[] nums, LinkedList<Integer> track, boolean[] visit, List<List<Integer>> res) {
    if (track.size() == nums.length) {
      res.add(new LinkedList<>(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visit[i]) continue;
      // 防止重复
      if (i > 0 && nums[i - 1] == nums[i] && !visit[i - 1]) continue;

      track.add(nums[i]);
      visit[i] = true;
      recursion(nums, track, visit, res);
      visit[i] = false;
      track.removeLast();
    }
  }
}
