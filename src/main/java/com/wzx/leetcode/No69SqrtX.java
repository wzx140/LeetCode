package com.wzx.leetcode;

/**
 * @author wzx
 * @see <a href="https://leetcode.com/problems/sqrtx/">https://leetcode.com/problems/sqrtx/</a>
 */
public class No69SqrtX {

  /**
   * 二分搜索
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public int mySqrt(int x) {
    if (x == 0) return 0;
    if (x < 4) return 1;

    int start = 2, end = x / 2;
    while (start < end) {
      int middle = (end - start) / 2 + start;
      long mul = (long) middle * middle;
      if (mul > x) {
        end = middle - 1;
      } else if (mul < x) {

        long nextMul = (long) (middle + 1) * (middle + 1);
        if (nextMul > x) return middle;

        start = middle + 1;
      } else {
        return middle;
      }
    }

    return start;
  }
}
