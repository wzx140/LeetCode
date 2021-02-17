package com.wzx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/permutations/">https://leetcode.com/problems/permutations/</a>
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
    boolean[] visit = new boolean[nums.length];
    recursion(nums, visit, new LinkedList<>(), res);

    return res;
  }

  private void recursion(int[] nums, boolean[] visit, LinkedList<Integer> track, List<List<Integer>> res) {
    if (track.size() == nums.length) {
      res.add(new LinkedList<>(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // 首个搜索元素在循环内添加, 所以visit判断在循环内部
      if (visit[i]) continue;
      track.add(nums[i]);
      visit[i] = true;
      recursion(nums, visit, track, res);
      visit[i] = false;
      track.removeLast();
    }
  }
}
