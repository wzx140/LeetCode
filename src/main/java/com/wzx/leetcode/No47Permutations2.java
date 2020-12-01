package com.wzx.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 *
 * @author wzx
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
      if (!visit[i]) {

        if (i > 0 && nums[i - 1] == nums[i] && !visit[i - 1]) {
          // 当前元素m和不在track序列中的且m之前的元素相同
          // 这说明在之前添加的track序列中相同位置已经放置过与m相同的元素了
          continue;
        }

        track.add(nums[i]);
        visit[i] = true;
        recursion(nums, track, visit, res);
        visit[i] = false;
        track.removeLast();
      }
    }
  }
}
