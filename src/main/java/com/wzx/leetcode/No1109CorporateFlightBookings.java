package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/corporate-flight-bookings/
 *
 * @author wzx
 */
public class No1109CorporateFlightBookings {

  /**
   * 暴力
   * <p>
   * time: O(n^2)
   * space: O(n)
   */
  public int[] corpFlightBookings1(int[][] bookings, int n) {
    int[] res = new int[n];
    for (int[] booking : bookings) {
      int begin = booking[0] - 1;
      int end = booking[1] - 1;
      int seatNum = booking[2];

      for (int i = begin; i <= end; i++) {
        res[i] += seatNum;
      }
    }

    return res;
  }

  /**
   * 差分数组
   * <p>
   * time: O(n)
   * space: O(n)
   */
  public int[] corpFlightBookings2(int[][] bookings, int n) {
    // diff[i] = origin[i] - origin[i-1]
    int[] res = new int[n];

    for (int[] booking : bookings) {
      int begin = booking[0] - 1;
      int end = booking[1] - 1;
      int seatNum = booking[2];

      // diff[i]+num -> origin[i]+num, origin[i+1]+num, ..., origin[n]+num
      res[begin] += seatNum;
      // diff[i]-num -> origin[i]-num, origin[i+1]-num, ..., origin[n]-num
      if (end < n - 1) res[end + 1] -= seatNum;
    }

    // origin[i] = diff[0~i]
    for (int i = 1; i < n; i++) {
      res[i] += res[i - 1];
    }

    return res;
  }
}
