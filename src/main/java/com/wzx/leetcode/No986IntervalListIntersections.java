package com.wzx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/interval-list-intersections/">https://leetcode.com/problems/interval-list-intersections/</a>
 * @author wzx
 */
public class No986IntervalListIntersections {

  /**
   * 先排序，再画图考虑多种情况
   *
   * time: O(n)
   * space: O(n)
   */
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int i = 0, j = 0;

    List<int[]> res = new ArrayList<>();

    while (i < firstList.length && j < secondList.length) {
      int a1 = firstList[i][0], a2 = firstList[i][1];
      int b1 = secondList[j][0], b2 = secondList[j][1];

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

    return res.toArray(new int[res.size()][2]);
  }
}
