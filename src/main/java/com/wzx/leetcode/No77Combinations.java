package com.wzx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 *
 * @author wzx
 */
public class No77Combinations {

  private List<List<Integer>> res = null;

  /**
   * 回溯
   *
   * time: O(A_n^k*k), clone=O(k)
   * space: O(n)
   */
  public List<List<Integer>> combine(int n, int k) {
    res = new LinkedList<>();
    recursion(1, n, k, new LinkedList<>());
    return res;
  }

  private void recursion(int start, int n, int k, LinkedList<Integer> track) {
    if (k == 0) res.add(new LinkedList<>(track));

    for (int i = start; i <= n; i++) {
      track.add(i);
      recursion(i + 1,n, k - 1, track);
      track.removeLast();
    }
  }
}
