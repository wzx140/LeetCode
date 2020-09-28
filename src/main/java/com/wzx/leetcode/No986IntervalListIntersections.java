package com.wzx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 *
 * @author wzx
 */
public class No986IntervalListIntersections {

  /**
   * 先排序，再画图考虑多种情况
   *
   * time: O(n)
   * space: O(n)
   */
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    int i = 0, j = 0;

    List<int[]> res = new LinkedList<>();

    while (i < A.length && j < B.length) {
      int a1 = A[i][0], a2 = A[i][1];
      int b1 = B[j][0], b2 = B[j][1];

      if (a1 > b2) {
        // a        |---|
        // b  |---|
        j++;
      } else if (b1 > a2) {
        // a  |---|
        // b        |---|
        i++;
      } else {
        res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});

        // a  ---|
        // b  -----|
        if (a2 < b2) i++;

        // a  -----|
        // b  ---|
        else j++;
      }
    }

    return res.toArray(new int[res.size()][0]);
  }
}
