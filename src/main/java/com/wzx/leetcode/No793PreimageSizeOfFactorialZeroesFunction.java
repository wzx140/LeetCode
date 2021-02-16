package com.wzx.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/">https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/</a>
 * @author wzx
 */
public class No793PreimageSizeOfFactorialZeroesFunction {

  /**
   * 由No172FactorialTrailingZeroes可知 阶乘n与结尾0的个数的映射关系g(n)
   * g(n)一定是单调递增的, 所以可以使用二分搜索找到n的上下界
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public int preimageSizeFZF(int K) {
    long start = 0, end= Long.MAX_VALUE;
    long upper = upper(start, end, K);
    long lower = lower(start, end, K);
    return upper != -1 && lower != -1 ? (int) (upper - lower + 1) : 0;
  }

  private long upper(long start, long end, int target) {
    while (start <= end) {
      long middle = (end - start) / 2 + start;
      long middleValue = trailingZeroes(middle);
      if (middleValue > target) {
        end = middle - 1;
      } else {
        start = middle + 1;
      }
    }

    long ret = -1;
    if (end >= 0 && trailingZeroes(end) == target) ret = end;
    return ret;
  }

  private long lower(long start, long end, int target) {
    while (start <= end) {
      long middle = (end - start) / 2 + start;
      long middleValue = trailingZeroes(middle);
      if (middleValue < target) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }

    long ret = -1;
    if (start >= 0 && trailingZeroes(start) == target) ret = start;
    return ret;
  }

  private long trailingZeroes(long n) {
    long num = n;
    long fiveFactor = 0;
    while (num >= 5) {
      // num为因数5, 25, ... ,个数
      num /= 5;
      fiveFactor += num;
    }

    return fiveFactor;
  }
}
