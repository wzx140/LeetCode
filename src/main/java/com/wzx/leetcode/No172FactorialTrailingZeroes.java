package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/factorial-trailing-zeroes/">https://leetcode.com/problems/factorial-trailing-zeroes/</a>
 * @author wzx
 */
public class No172FactorialTrailingZeroes {

  /**
   * 因数2, 5产生一个0, 因为因数2总是最多的, 所以看阶乘中有多少因数5
   *
   * time: O(logn)
   * space: O(1)
   */
  public int trailingZeroes(int n) {
    int num = n;
    int fiveFactor = 0;
    while (num >= 5) {
      // num为因数5, 25, ... ,个数
      num /= 5;
      fiveFactor += num;
    }

    return fiveFactor;
  }
}
