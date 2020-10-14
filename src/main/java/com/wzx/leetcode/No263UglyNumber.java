package com.wzx.leetcode;

/**
 * https://leetcode.com/problems/ugly-number/
 *
 * @author wzx
 */
public class No263UglyNumber {

  /**
   * 因数分解
   *
   * time: O(logn)
   * space: O(1)
   */
  public boolean isUgly(int num) {
    if (num <= 0) return false;
    while (num % 2 == 0) num /= 2;
    while (num % 3 == 0) num /= 3;
    while (num % 5 == 0) num /= 5;

    return Math.abs(num) == 1;
  }
}
