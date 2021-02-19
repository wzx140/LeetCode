package com.wzx.leetcode;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/exam-room/">https://leetcode.com/problems/exam-room/</a>
 * @author wzx
 */
public class No855ExamRoom {

  /**
   * 将所有考生看成两两成对的线段
   */
  public static class ExamRoom {

    /**
     * 根据自定义长度排序的线段集合
     */
    private final TreeSet<int[]> intervalSet;

    /**
     * 以key为左端点的线段
     */
    private final Map<Integer, int[]> leftMap;

    /**
     * 以key为右端点的线段
     */
    private final Map<Integer, int[]> rightMap;

    private final int N;

    /**
     * 返回线段端点(exclude)至中点(include)的距离
     */
    private int distance(int[] interval) {
      int left = interval[0];
      int right = interval[1];
      if (left == -1) return right;
      if (right == N) return N - left - 1;
      return (right - left) / 2;
    }

    private void remove(int[] interval){
      intervalSet.remove(interval);
      leftMap.remove(interval[0]);
      rightMap.remove(interval[1]);
    }

    private void add(int[] interval){
      intervalSet.add(interval);
      leftMap.put(interval[0], interval);
      rightMap.put(interval[1], interval);
    }

    public ExamRoom(int N) {
      this.N = N;
      intervalSet = new TreeSet<>(
              (interval1, interval2) -> {
                int dist1 = distance(interval1);
                int dist2 = distance(interval2);
                // 优先分配索引较小的位置
                if (dist1 == dist2) {
                  return interval1[0] - interval2[0];
                }
                return dist2 - dist1;
              });
      leftMap = new HashMap<>();
      rightMap = new HashMap<>();
      // dummy
      int[] dummyInterval = new int[]{-1, N};
      intervalSet.add(dummyInterval);
      leftMap.put(-1, dummyInterval);
      rightMap.put(N, dummyInterval);
    }

    public int seat() {
      // 取出最大距离线段
      int[] interval = intervalSet.first();
      // 分裂成两个
      int seat;
      if (interval[0] == -1) {
        seat = 0;
      } else if (interval[1] == N) {
        seat = N - 1;
      } else {
        seat = (interval[1] - interval[0]) / 2 + interval[0];
      }
      int[] leftInterval = new int[]{interval[0], seat};
      int[] rightInterval = new int[]{seat, interval[1]};
      remove(interval);
      add(leftInterval);
      add(rightInterval);

      return seat;
    }

    public void leave(int p) {
      // 合并此位置两侧的线段
      int[] leftInterval = rightMap.get(p);
      int[] rightInterval = leftMap.get(p);
      int[] newInterval = new int[]{leftInterval[0], rightInterval[1]};
      remove(leftInterval);
      remove(rightInterval);
      add(newInterval);
    }
  }
}
