package com.wzx.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class No1109CorporateFlightBookingsTest {

  private final int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
  private final int[] res = new int[]{10, 55, 45, 25, 25};

  @Test
  public void corpFlightBookings1() {
    No1109CorporateFlightBookings solution = new No1109CorporateFlightBookings();
    assertArrayEquals(res, solution.corpFlightBookings1(bookings, 5));
  }

  @Test
  public void corpFlightBookings2() {
    No1109CorporateFlightBookings solution = new No1109CorporateFlightBookings();
    assertArrayEquals(res, solution.corpFlightBookings2(bookings, 5));
  }
}