package com.wzx.sword;

/**
 * @see <a href="https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/">https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/</a>
 * @author wzx
 */
public class No16IntegerPower {

  /**
   * 快速幂 递归
   * a^n = a^(n/2) * a^(n/2) ; n为偶数
   * a^n = a^((n-1)/2) * a^((n-1)/2) * a ; n为奇数
   * <p>
   * time: O(logn)
   * space: O(logn)
   */
  public double myPow1(double x, int n) {
    if (x == 0) return 0;
    if (n == 0) return 1;
    if (n == -1) return 1 / x;

    // -3 / 2 = -1
    // -3 >> 1 = -2
    double r = myPow1(x, n >> 1);

    if ((n & 1) == 0) {
      // n为偶数
      return r * r;
    } else {
      // n为奇数
      return r * r * x;
    }
  }

  /**
   * 快速幂 迭代
   * n^x = n^0 * n^(2^1) * n^(2^2) * ... * n^(x^log_2(x))
   * <p>
   * time: O(logn)
   * space: O(1)
   */
  public double myPow2(double x, int n) {
    if (x == 0) return 0;
    if (n == 0) return 1;

    // 防止指数绝对值越界
    long b = n;
    if (n < 0) {
      x = 1 / x;
      b = -b;
    }
    double res = 1.0;

    while (b > 0) {
      if ((b & 1) == 1) {
        // 当前位是1, 将累乘值x乘入返回值
        res *= x;
      }
      // 更新累乘值x n^(2^k)
      x *= x;
      b >>= 1;
    }

    return res;
  }
}
